package org.jboss.spring.samples.sportsclub.invoicing.services;

import java.math.BigDecimal;

import javax.ejb.Local;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

@Local
public interface BillingService
{
   void generateInvoice(Account account);

   void processPayment(Account account, BigDecimal amount);
}
