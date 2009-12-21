package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;

import javax.faces.model.SelectItem;
import java.util.Collection;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReferenceData
{
   private SelectItem[] equipmentTypes;
   private SelectItem[] equipments;

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

      Collection<Equipment> eqps =  equipmentService.getAllEquipments();
      equipments = new SelectItem[eqps.size()];
      i = 0;
      for (Equipment e : eqps)
      {
         String label = e.getEquipmentType().name() + ", " + e.getDescription();
         equipments[i++] = new SelectItem(e, label);
      }

   }

   public SelectItem[] getEquipmentTypes()
   {
      return equipmentTypes;
   }

   public SelectItem[] getAllEquipments()
   {
      return equipments;
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
