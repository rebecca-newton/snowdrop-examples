package org.jboss.snowdrop.samples.sportsclub.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Marius Bogoevici
 */
public class DateUtils
{
   public static Date normalizeDate(Date date, TimeZone timeZone)
   {
      Calendar calendar = new GregorianCalendar(timeZone);
      calendar.setTime(date);
      calendar.set(Calendar.AM_PM, Calendar.AM);
      calendar.set(Calendar.HOUR, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      return calendar.getTime();
   }
}
