package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Collection;

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

   public void save(T object)
   {
      this.entityManager.persist(object);
   }

   public void delete(T object)
   {
      this.entityManager.remove(object);
   }

   public Collection<T> findAll()
   {
      return entityManager.createQuery("SELECT c FROM " + clazz.getSimpleName() + " c").getResultList();
   }

   public long countAll()
   {
      return (Long)entityManager.createQuery("SELECT COUNT(c) FROM " + clazz.getSimpleName() + " c").getSingleResult();
   }
}
