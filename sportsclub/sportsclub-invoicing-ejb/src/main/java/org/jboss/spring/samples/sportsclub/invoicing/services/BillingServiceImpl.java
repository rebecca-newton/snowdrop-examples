package org.jboss.spring.samples.sportsclub.invoicing.services;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.jboss.annotation.spring.Spring;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.BalanceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.jboss.spring.callback.SpringLifecycleInterceptor;

@Stateless
@Interceptors(SpringLifecycleInterceptor.class)
public class BillingServiceImpl implements BillingService
{
   @Spring(bean = "invoiceRepository", jndiName = "SpringDao")
   private InvoiceRepository invoiceRepository;

   @Spring(bean = "balanceRepository", jndiName = "SpringDao")
   private BalanceRepository balanceRepository;

   @Spring(bean = "paymentRepository", jndiName = "SpringDao")
   private PaymentRepository paymentRepository;

   public Invoice generateInvoice(Account account)
   {
      Invoice invoice = new Invoice();
      invoice.setAccount(account);
      invoice.setAmount(account.getFeePerBillingPeriod());
      invoice.setDate(new Date());
      invoiceRepository.save(invoice);
      Balance balance = balanceRepository.findForAccount(account);
      balance.debit(invoice.getAmount());
      balanceRepository.save(balance);
      return invoice;
   }

   public void processPayment(Account account, BigDecimal amount)
   {
      Payment payment = new Payment();
      payment.setAccount(account);
      payment.setAmount(amount);
      payment.setDate(new Date());
      paymentRepository.save(payment);
      Balance balance = balanceRepository.findForAccount(account);
      balance.credit(amount);
      balanceRepository.save(balance);
   }
   

   public Balance getBalance(Account account)
   {
      return balanceRepository.findForAccount(account);
   }

}
