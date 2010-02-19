package org.jboss.snowdrop.samples.sportsclub.service.payment;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class PaymentProcessorImpl implements PaymentProcessor
{
   @Autowired
   private AccountRepository accountRepository;

   @Autowired
   private PaymentRepository paymentRepository;

   @Transactional
   public Long processPayment(Long accountId, BigDecimal amount)
   {
      Account account = accountRepository.findById(accountId);
      Payment payment = new Payment();
      payment.setAccount(account);

      payment.setAmount(amount);
      payment.setDate(new Date());
      paymentRepository.save(payment);
      Balance balance = account.getBalance();
      balance.credit(amount);
      accountRepository.save(account);
      return payment.getId();
   }
}