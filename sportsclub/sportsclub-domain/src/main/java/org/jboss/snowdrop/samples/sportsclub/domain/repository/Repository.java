package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public interface Repository<T, I>
{
   T findById(I id);

   void save(T object);

   void delete(T object);

   List<T> findAll();
   
   long countAll();
}
