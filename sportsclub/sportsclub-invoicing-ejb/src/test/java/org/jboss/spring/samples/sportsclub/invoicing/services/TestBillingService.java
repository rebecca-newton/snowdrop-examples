package org.jboss.spring.samples.sportsclub.invoicing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Marius Bogoevici
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml", "classpath:dao-context.xml", "classpath:service-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBillingService
{

   @Autowired
   BillingService billingService;

   @Autowired
   AccountRepository accountRepository;

   @Transactional @Test
   public void testBillingService()
   {
      Account account = accountRepository.findById(1l);
      Invoice invoice = billingService.generateInvoice(account);
   }

}
