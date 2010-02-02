package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.springframework.stereotype.Repository;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PersonRepository;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@Repository
public class JpaPersonRepository extends JpaRepository<Person, Long> implements PersonRepository
{
   public JpaPersonRepository()
   {
      super(Person.class);
   }
}
