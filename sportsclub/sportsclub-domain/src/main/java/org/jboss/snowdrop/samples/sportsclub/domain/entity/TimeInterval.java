package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @author Marius Bogoevici
 */
@Embeddable
public class TimeInterval
{
   private Date startDate;

   private Date endDate;

   public Date getEndDate()
   {
      return endDate;
   }

   public void setEndDate(Date endDate)
   {
      this.endDate = endDate;
   }

   public Date getStartDate()
   {
      return startDate;
   }

   public void setStartDate(Date startDate)
   {
      this.startDate = startDate;
   }

   public boolean contains(Date someDate)
   {
      return someDate.compareTo(startDate) >= 0 && someDate.compareTo(endDate)<=0;
   }
}
