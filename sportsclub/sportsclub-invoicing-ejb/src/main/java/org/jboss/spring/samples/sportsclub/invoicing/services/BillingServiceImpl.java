package org.jboss.spring.samples.sportsclub.invoicing.services;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Stateless;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.BalanceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;

@Stateless
public class BillingServiceImpl implements BillingService
{
   private InvoiceRepository invoiceRepository;
   private BalanceRepository balanceRepository;
   private PaymentRepository paymentRepository;

   public void setInvoiceRepository(InvoiceRepository invoiceRepository)
   {
      this.invoiceRepository = invoiceRepository;
   }

   public void setBalanceRepository(BalanceRepository balanceRepository)
   {
      this.balanceRepository = balanceRepository;
   }

   public void setPaymentRepository(PaymentRepository paymentRepository)
   {
      this.paymentRepository = paymentRepository;
   }

   public void generateInvoice(Account account)
   {
      Invoice invoice = new Invoice();
      invoice.setAccount(account);
      invoice.setAmount(account.getFeePerBillingPeriod());
      invoice.setDate(new Date());
      invoiceRepository.save(invoice);
      Balance balance = balanceRepository.findForAccount(account);
      balance.debit(invoice.getAmount());
      balanceRepository.save(balance);
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
