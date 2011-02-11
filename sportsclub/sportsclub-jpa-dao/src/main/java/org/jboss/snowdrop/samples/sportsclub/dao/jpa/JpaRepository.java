package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.Repository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract repository using JPA EntityManager.
 *
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public abstract class JpaRepository<T, I extends Serializable> implements Repository<T, I>
{
   @Autowired
   protected EntityManager entityManager;

   Class<T> clazz;

   public JpaRepository(Class<T> clazz)
   {
      this.clazz = clazz;
   }

   public T findById(I id)
   {
      return this.entityManager.find(clazz, id);
   }

   public T save(T object)
   {
      return this.entityManager.merge(object);
   }

   public void delete(T object)
   {
      this.entityManager.remove(object);
   }

   @SuppressWarnings("unchecked")
   public List<T> findAll()
   {
      return entityManager.createQuery("SELECT c FROM " + clazz.getSimpleName() + " c").getResultList();
   }

   public long countAll()
   {
      return (Long)entityManager.createQuery("SELECT COUNT(c) FROM " + clazz.getSimpleName() + " c").getSingleResult();
   }

   public Query applyRange(Query query, Range range)
   {
      return query.setFirstResult(range.getMinIndex()).setMaxResults(range.length());
   }
}
