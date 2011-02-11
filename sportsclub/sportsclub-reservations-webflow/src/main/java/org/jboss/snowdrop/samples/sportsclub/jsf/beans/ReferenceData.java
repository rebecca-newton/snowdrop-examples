package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;

import javax.faces.model.SelectItem;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReferenceData
{
   private SelectItem[] equipmentTypes;
   private EquipmentService equipmentService;

   public void init()
   {
      EquipmentType[] types = equipmentService.getEquipmentTypes();
      equipmentTypes = new SelectItem[types.length];
      int i = 0;
      for (EquipmentType type : types)
      {
         equipmentTypes[i++] = new SelectItem(type);
      }

   }

   public SelectItem[] getEquipmentTypes()
   {
      return equipmentTypes;
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
