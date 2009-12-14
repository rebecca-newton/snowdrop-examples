package org.jboss.spring.samples.sportsclub.invoicing.services;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;

public class BillingServiceImpl implements BillingService
{

   public void submitInvoice(Account account)
   {
      Invoice invoice = new Invoice();
      invoice.setAccount(account);
      
   }
}
