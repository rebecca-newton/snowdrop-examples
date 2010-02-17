package org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria;

import java.util.Date;
import java.util.TimeZone;

import org.jboss.snowdrop.samples.sportsclub.utils.DateUtils;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class InvoiceSearchCriteria
{
   private Date referenceDate;

   private boolean existingInvoice;

   public InvoiceSearchCriteria(Date referenceDate)
   {
      this.referenceDate = DateUtils.normalizeDate(referenceDate, TimeZone.getTimeZone("EST"));
   }

   public void setExistingInvoice(boolean existingInvoice)
   {
      this.existingInvoice = existingInvoice;
   }

   public boolean isExistingInvoice()
   {
      return existingInvoice;
   }

   public Date getReferenceDate()
   {
      return referenceDate;
   }


}
