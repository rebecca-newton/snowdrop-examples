package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;

import java.util.List;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
                                   "classpath:TEST-jpa-infrastructure.xml",
                                   "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJpaInvoiceRepository
{
   @Autowired
   InvoiceRepository invoiceRepository;

   @Autowired
   AccountRepository accountRepository;

   @Test
   @Transactional
   public void testFindForAccount()
   {
      Account a = accountRepository.findById(2L);
      List<Invoice> invoices = invoiceRepository.findForAccount(a);
      Assert.assertNotNull(invoices);
      Assert.assertEquals(1, invoices.size());
   }
}
