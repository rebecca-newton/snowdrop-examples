package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.*;
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
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
      "classpath:test-hibernate-infrastructure.xml",
      "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestHibernateAccountRepository
{

   @Autowired
   AccountRepository accountRepository;
   private static final Date TEST_DATE = new GregorianCalendar(2010, 1, 4).getTime();

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

   @Test
   public void testRangeCriteria()
   {
      AccountSearchCriteria criteria = new AccountSearchCriteria();
      criteria.setRange(new Range(1,3));
      List<Account> accountList = accountRepository.findByCriteria(criteria);
      Assert.assertEquals(3, accountList.size());
   }

   @Test
   public void testAccountRepositoryWithInvoices()
   {
      AccountSearchCriteria criteria = new AccountSearchCriteria();
      criteria.setInvoiceSearchCriteria(new InvoiceSearchCriteria(TEST_DATE));
      criteria.getInvoiceSearchCriteria().setExistingInvoice(true);
      List<Account> accountList = accountRepository.findByCriteria(criteria);
      Assert.assertEquals(1, accountList.size());
      Account account = accountList.get(0);
      Assert.assertEquals(new Long(2L), account.getId());
      Assert.assertNotNull(account.getBalance());
   }

   @Test
   public void testAccountRepositoryWithoutInvoices()
   {
      AccountSearchCriteria criteria = new AccountSearchCriteria();
      criteria.setInvoiceSearchCriteria(new InvoiceSearchCriteria(TEST_DATE));
      criteria.getInvoiceSearchCriteria().setExistingInvoice(false);
      List<Account> accountList = accountRepository.findByCriteria(criteria);
      Assert.assertEquals(11, accountList.size());
      for (Account account : accountList)
      {
         Assert.assertFalse(2l == account.getId());
      }
   }
}
