package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;

import javax.faces.model.SelectItem;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReferenceData
{
   private EquipmentService equipmentService;

   public SelectItem[] getEquipmentTypes()
   {
      EquipmentType[] types = getEquipmentService().getEquipmentTypes();
      SelectItem[] items = new SelectItem[types.length];
      int i = 0;
      for (EquipmentType type : types)
      {
         items[i++] = new SelectItem(type);
      }
      return items;
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
