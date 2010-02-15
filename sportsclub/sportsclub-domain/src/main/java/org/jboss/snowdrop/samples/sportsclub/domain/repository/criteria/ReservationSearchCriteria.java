package org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;

import java.util.Date;
import java.util.List;

/**
 */
public class ReservationSearchCriteria extends RangeCriteria
{
   private Date fromDate;

   private Date toDate;

   private List<EquipmentType> equipmentType;

   public Date getFromDate()
   {
      return fromDate;
   }

   public void setFromDate(Date fromDate)
   {
      this.fromDate = fromDate;
   }

   public Date getToDate()
   {
      return toDate;
   }

   public void setToDate(Date toDate)
   {
      this.toDate = toDate;
   }

   public List<EquipmentType> getEquipmentType()
   {
      return equipmentType;
   }

   public void setEquipmentType(List<EquipmentType> equipmentType)
   {
      this.equipmentType = equipmentType;
   }
}
