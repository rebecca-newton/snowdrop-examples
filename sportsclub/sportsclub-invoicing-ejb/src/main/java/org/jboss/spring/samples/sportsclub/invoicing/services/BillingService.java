package org.jboss.spring.samples.sportsclub.invoicing.services;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BillingService
{
   /**
    * Generate a new {@link Invoice} for given {@link Account}
    * @param account
    * @return
    */
   Invoice generateInvoice(Account account);

   /**
    * Get all {@link Invoice}s for given {@link Account}
    * @param account
    * @return
    */
   List<Invoice> getInvoices(Account account);

   /**
    * Get all {@link Payment}s for given {@link Account}
    * @param account
    * @return
    */
   List<Payment> getPayments(Account account);
}
