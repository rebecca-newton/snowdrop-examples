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
      String s = e.getId() + " " + e.getName();
      return s;
   }

   public Equipment getAsEquipment(String s) throws RuntimeException
   {
      String[] items = s.split(" ",2);
      Equipment e = getEquipmentService().findEquipmentById(Long.valueOf(items[0]));
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
