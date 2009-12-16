package org.jboss.snowdrop.samples.sportsclub.domain.entity;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public enum BillingType
{
   MONTHLY(12),

   SEMIMONTHLY(24),

   BIWEEKLY(26),

   WEEKLY(52);

   private int periods;

   BillingType(int periods)
   {
      this.periods = periods;
   }

   public int periodsPerYear()
   {
     return periods;
   }
}
