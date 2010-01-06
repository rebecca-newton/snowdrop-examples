package org.jboss.spring.samples.sportsclub.invoicing.services;

import java.math.BigDecimal;

import javax.ejb.Local;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;

@Local
public interface BillingService
{
   Invoice generateInvoice(Account account);

   void processPayment(Account account, BigDecimal amount);
}
