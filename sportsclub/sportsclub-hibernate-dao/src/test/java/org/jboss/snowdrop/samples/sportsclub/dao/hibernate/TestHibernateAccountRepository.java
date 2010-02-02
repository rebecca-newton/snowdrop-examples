package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.PersonSearchCriteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml", "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestHibernateAccountRepository
{

   @Autowired
   AccountRepository accountRepository;

   @Test
   public void testAccountRepository()
   {
      Collection<Account> accounts = accountRepository.findAll();
      Assert.assertEquals(12, accounts.size());

      AccountSearchCriteria criteria = new AccountSearchCriteria();
      PersonSearchCriteria personCriteria = new PersonSearchCriteria();
      personCriteria.setName("Vetinari");
      criteria.setPersonSearchCriteria(personCriteria);
      List<Account> accountList = accountRepository.findByCriteria(criteria);
      Account account = accountList.get(0);
      Assert.assertNotNull(account.getBalance());
   }
}
