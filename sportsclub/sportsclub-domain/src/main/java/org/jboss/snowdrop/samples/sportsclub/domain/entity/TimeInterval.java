package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Embeddable;

import org.jboss.snowdrop.samples.sportsclub.utils.DateUtils;

/**
 * @author Marius Bogoevici
 */
@Embeddable
public class TimeInterval
{
   public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("EST");

   public static final long TWO_WEEKS = (14 * 24 * 3600 * 1000);

   private Date startDate;

   private Date endDate;


   public Date getEndDate()
   {
      return endDate;
   }

   public void setEndDate(Date endDate)
   {
      this.endDate = DateUtils.normalizeDate(endDate,TIME_ZONE);
   }

   public Date getStartDate()
   {
      return startDate;
   }

   public void setStartDate(Date startDate)
   {
      this.startDate = DateUtils.normalizeDate(startDate,TIME_ZONE);
   }

   public boolean contains(Date someDate)
   {
      Date normalizeDate = DateUtils.normalizeDate(someDate,TIME_ZONE);
      return normalizeDate.compareTo(startDate) >= 0 && normalizeDate.compareTo(endDate)<=0;
   }
}
