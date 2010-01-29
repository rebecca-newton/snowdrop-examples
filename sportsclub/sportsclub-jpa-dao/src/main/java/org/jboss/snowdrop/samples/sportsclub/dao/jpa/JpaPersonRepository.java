package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PersonRepository;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class JpaPersonRepository extends JpaRepository<Person, Integer> implements PersonRepository
{
   public JpaPersonRepository()
   {
      super(Person.class);
   }
}
