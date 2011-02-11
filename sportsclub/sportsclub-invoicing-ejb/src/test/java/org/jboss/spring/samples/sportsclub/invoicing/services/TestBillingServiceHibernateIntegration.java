package org.jboss.spring.samples.sportsclub.invoicing.services;

import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author Marius Bogoevici
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
      "classpath:dao-context.xml",
      "classpath:test-hibernate-infrastructure.xml",
      "classpath:service-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBillingServiceHibernateIntegration
{

   @Autowired
   BillingService billingService;

   @Autowired
   AccountRepository accountRepository;

   @Autowired
   private PlatformTransactionManager transactionManager;

   @SuppressWarnings({ "unchecked", "rawtypes" })
   @Test
   public void testBillingService()
   {

	final Invoice invoice = (Invoice)new TransactionTemplate(transactionManager).execute(new TransactionCallback()
      {
         public Object doInTransaction(TransactionStatus status)
         {
            Account account = accountRepository.findById(1l);
            Invoice invoice = billingService.generateInvoice(account);
            return invoice;
         }
      });


      new TransactionTemplate(transactionManager).execute(new TransactionCallback()
      {
         public Object doInTransaction(TransactionStatus status)
         {
            Account account = accountRepository.findById(1l);
            Assert.assertEquals(account.getBalance().getAmount(), invoice.getAmount());
            return null;
         }
      });
   }

}
