package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.Repository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;

/**
 * Abstract repository using Hibernate SessionFactory.
 *
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public abstract class HibernateRepository<T, I extends Serializable> implements Repository<T, I>
{
   protected SessionFactory sessionFactory;

   Class<T> clazz;

   public HibernateRepository(Class<T> clazz)
   {
      this.clazz = clazz;
   }

   public void setSessionFactory(SessionFactory sessionFactory)
   {
      this.sessionFactory = sessionFactory;
   }

   protected Session getCurrentSession()
   {
      return this.sessionFactory.getCurrentSession();
   }

   @SuppressWarnings("unchecked")
   public T findById(I id)
   {
      return (T)getCurrentSession().get(clazz, id);
   }

   @SuppressWarnings("unchecked")
   public T save(T object)
   {
      return (T) getCurrentSession().merge(object);
   }

   public void delete(T object)
   {
      getCurrentSession().delete(object);
   }

   @SuppressWarnings("unchecked")
   public List<T> findAll()
   {
      return getCurrentSession().createCriteria(clazz).list();
   }


   public long countAll()
   {
      return (Integer)getCurrentSession().createCriteria(clazz).setProjection(Projections.count("id")).uniqueResult();
   }

   public Criteria applyRange(Criteria criteria, Range range)
   {
      return criteria.setFirstResult(range.getMinIndex()).setMaxResults(range.length());
   }
}
