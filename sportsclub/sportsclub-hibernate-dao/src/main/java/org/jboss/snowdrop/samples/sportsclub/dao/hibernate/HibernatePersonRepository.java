package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PersonRepository;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public class HibernatePersonRepository extends HibernateRepository<Person, Long> implements PersonRepository
{

   public HibernatePersonRepository()
   {
      super(Person.class);
   }

}
