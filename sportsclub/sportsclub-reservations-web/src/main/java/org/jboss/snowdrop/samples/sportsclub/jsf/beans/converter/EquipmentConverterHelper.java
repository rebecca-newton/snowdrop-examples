package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class EquipmentConverterHelper
{

   private EquipmentService equipmentService;

   public String getAsString(Equipment e) throws RuntimeException
   {
      return String.valueOf(e.getId());
   }

   public Equipment getAsEquipment(String s) throws RuntimeException
   {
      Equipment e = getEquipmentService().findEquipmentById(Long.valueOf(s));
      return e;
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
