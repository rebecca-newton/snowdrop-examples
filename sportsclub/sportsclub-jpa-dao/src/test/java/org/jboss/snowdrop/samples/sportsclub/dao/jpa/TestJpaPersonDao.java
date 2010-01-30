package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Marius Bogoevici
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml",
                                   "classpath:TEST-jpa-infrastructure.xml",
                                   "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJpaPersonDao
{
   @Autowired
   PersonRepository personRepository;

   @Test
   public void testPersonRepository()
   {
      long count = personRepository.countAll();
      Assert.assertEquals(12, count);
   }
}
