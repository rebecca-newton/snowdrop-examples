package org.jboss.snowdrop.samples.sportsclub.service.payment;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.PaymentNotification;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import sun.security.krb5.internal.ktab.KeyTab;

/**
 * @author Marius Bogoevici
 */
@Component
public class PaymentProcessor
{

   @Autowired
   private AccountRepository accountRepository;

   @Autowired
   private PaymentRepository paymentRepository;

   public void processPaymentNotification(PaymentNotification paymentNotification)
   {
      Account account = accountRepository.findById(paymentNotification.getAccountNumber());
      Payment payment = new Payment();
      payment.setAccount(account);
      payment.setAmount(paymentNotification.getAmount());
      payment.setDate(new Date());
      System.out.println(account);
      paymentRepository.save(payment);
      Balance balance = account.getBalance();
      balance.credit(paymentNotification.getAmount());
      accountRepository.save(account);
   }
}
