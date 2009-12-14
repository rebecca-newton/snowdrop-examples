package org.jboss.spring.samples.sportsclub.invoicing.services;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

public interface BillingService
{
   void submitInvoice(Account account);
}
