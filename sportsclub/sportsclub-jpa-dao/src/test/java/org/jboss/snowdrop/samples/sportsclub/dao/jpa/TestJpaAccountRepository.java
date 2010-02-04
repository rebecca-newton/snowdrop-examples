package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.InvoiceSearchCriteria;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.PersonSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml",
                                   "classpath:TEST-jpa-infrastructure.xml",
                                   "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJpaAccountRepository
{
   @Autowired
   AccountRepository accountRepository;

   @Autowired
   InvoiceRepository invoiceRepository;

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
   public void testAccountRepositoryWithInvoices()
   {
      AccountSearchCriteria criteria = new AccountSearchCriteria();
      criteria.setInvoiceSearchCriteria(new InvoiceSearchCriteria());
      criteria.getInvoiceSearchCriteria().setCurrentInvoice(true);
      List<Account> accountList = accountRepository.findByCriteria(criteria);
      Assert.assertEquals(1, accountList.size());
      Account account = accountList.get(0);
      Assert.assertEquals(2l, account.getId());
      Assert.assertNotNull(account.getBalance());
   }

   @Test
   public void testAccountRepositoryWithoutInvoices()
   {
      AccountSearchCriteria criteria = new AccountSearchCriteria();
      criteria.setInvoiceSearchCriteria(new InvoiceSearchCriteria());
      criteria.getInvoiceSearchCriteria().setCurrentInvoice(false);
      List<Account> accountList = accountRepository.findByCriteria(criteria);
      Assert.assertEquals(11, accountList.size());
      for (Account account : accountList)
      {
         Assert.assertFalse(2l == account.getId());
      }      
   }
}
