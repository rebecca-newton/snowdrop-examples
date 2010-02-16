package org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria;

/**
 * Is used to narrow down number of rows pulled from
 * {@link org.jboss.snowdrop.samples.sportsclub.domain.repository.Repository}
 */
public class RangeCriteria
{
   private Range range;

   public Range getRange()
   {
      return range;
   }

   public void setRange(Range range)
   {
      this.range = range;
   }
}
