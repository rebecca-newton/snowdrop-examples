package org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public class AccountSearchCriteria extends RangeCriteria
{
   private PersonSearchCriteria personSearchCriteria;

   private InvoiceSearchCriteria invoiceSearchCriteria;

   private boolean activeOnly;

   public PersonSearchCriteria getPersonSearchCriteria()
   {
      return personSearchCriteria;
   }

   public void setPersonSearchCriteria(PersonSearchCriteria personSearchCriteria)
   {
      this.personSearchCriteria = personSearchCriteria;
   }

   public boolean isActiveOnly()
   {
      return activeOnly;
   }

   public void setActiveOnly(boolean activeOnly)
   {
      this.activeOnly = activeOnly;
   }

   public InvoiceSearchCriteria getInvoiceSearchCriteria()
   {
      return invoiceSearchCriteria;
   }

   public void setInvoiceSearchCriteria(InvoiceSearchCriteria invoiceSearchCriteria)
   {
      this.invoiceSearchCriteria = invoiceSearchCriteria;
   }
}
