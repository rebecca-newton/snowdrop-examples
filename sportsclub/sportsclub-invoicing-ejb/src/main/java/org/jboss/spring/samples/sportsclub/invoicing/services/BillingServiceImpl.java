package org.jboss.spring.samples.sportsclub.invoicing.services;

import org.jboss.annotation.spring.Spring;
import org.jboss.ejb3.annotation.LocalBinding;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.jboss.spring.callback.SpringLifecycleInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Date;

@Stateless
@Interceptors(SpringLifecycleInterceptor.class)
@LocalBinding(jndiBinding="sportsclub/BillingService")
public class BillingServiceImpl implements BillingService
{
   @Spring(bean = "invoiceRepository", jndiName = "SpringDao")
   private InvoiceRepository invoiceRepository;

   @Spring(bean = "accountRepository", jndiName = "SpringDao")
   private AccountRepository accountRepository;

   @Spring(bean = "paymentRepository", jndiName = "SpringDao")
   private PaymentRepository paymentRepository;

   public void setPaymentRepository(PaymentRepository paymentRepository)
   {
      this.paymentRepository = paymentRepository;
   }

   public void setAccountRepository(AccountRepository accountRepository)
   {
      this.accountRepository = accountRepository;
   }

   public void setInvoiceRepository(InvoiceRepository invoiceRepository)
   {
      this.invoiceRepository = invoiceRepository;
   }

   public Invoice generateInvoice(Account account)
   {
      Invoice invoice = new Invoice();
      invoice.setAccount(account);
      invoice.setAmount(account.getFeePerBillingPeriod());
      Date date = new Date();       
      invoice.setIssueDate(date);
      invoice.setBillingPeriod(account.getBillingPeriodFor(date));
      invoiceRepository.save(invoice);
      Balance balance = account.getBalance();
      balance.debit(invoice.getAmount());
      accountRepository.save(account);
      return invoice;
   }

 
}
