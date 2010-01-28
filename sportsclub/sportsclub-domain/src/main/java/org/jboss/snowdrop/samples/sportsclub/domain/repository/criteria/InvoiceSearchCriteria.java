package org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class InvoiceSearchCriteria
{
   private boolean currentInvoice;

   public boolean isCurrentInvoice()
   {
      return currentInvoice;
   }

   public void setCurrentInvoice(boolean currentInvoice)
   {
      this.currentInvoice = currentInvoice;
   }
}
