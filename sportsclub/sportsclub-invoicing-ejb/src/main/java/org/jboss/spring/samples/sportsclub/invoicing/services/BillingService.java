package org.jboss.spring.samples.sportsclub.invoicing.services;

import java.math.BigDecimal;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

public interface BillingService
{
   void generateInvoice(Account account);

   void processPayment(Account account, BigDecimal amount);
}
