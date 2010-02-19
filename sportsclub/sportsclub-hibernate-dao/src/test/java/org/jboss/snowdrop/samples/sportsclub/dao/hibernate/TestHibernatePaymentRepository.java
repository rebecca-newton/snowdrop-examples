package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;

import java.util.List;

import junit.framework.Assert;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
      "classpath:test-hibernate-infrastructure.xml",
      "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestHibernatePaymentRepository
{
   @Autowired
   AccountRepository accountRepository;

   @Autowired
   PaymentRepository paymentRepository;

   @Test
   public void testFindNoPaymentsForAccount()
   {
      Account a = accountRepository.findById(2L);
      List<Payment> payments = paymentRepository.findForAccount(a);

      Assert.assertEquals(0, payments.size());
   }
}
