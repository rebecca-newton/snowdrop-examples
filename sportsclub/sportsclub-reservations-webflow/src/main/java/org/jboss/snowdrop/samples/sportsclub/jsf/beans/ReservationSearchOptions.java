package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;

import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReservationSearchOptions
{
   private EquipmentService equipmentService;

   private Date fromDate;
   private Date toDate;
   private List<EquipmentType> selectedEquipmentTypes;
   private Locale locale;

   public void init()
   {
      locale = Locale.getDefault();
      selectedEquipmentTypes = Arrays.asList(getEquipmentService().getEquipmentTypes());
   }

   public Locale getLocale()
   {
      return locale;
   }

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

   public List<EquipmentType> getSelectedEquipmentTypes()
   {
      return selectedEquipmentTypes;
   }

   public void setSelectedEquipmentTypes(List<EquipmentType> selectedEquipmentTypes)
   {
      this.selectedEquipmentTypes = selectedEquipmentTypes;
   }

   public EquipmentService getEquipmentService()
   {
      return equipmentService;
   }

   public void setEquipmentService(EquipmentService equipmentService)
   {
      this.equipmentService = equipmentService;
   }
}
