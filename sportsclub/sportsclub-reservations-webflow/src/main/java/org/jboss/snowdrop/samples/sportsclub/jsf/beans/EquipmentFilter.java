package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;

import javax.faces.context.FacesContext;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class EquipmentFilter extends AbstractExtendedDataModelHelper
{
   private EquipmentService equipmentService;
   private Map<Long, Equipment> equipmentMap = new HashMap<Long, Equipment>();

   public EquipmentFilter()
   {
      super();
   }

   public Map<Long, ? extends Object> getDomainObjectMap()
   {
      return equipmentMap;
   }

   public Long getCurrentRowCount()
   {
      return equipmentService.countAllEquipments();
   }

   public void walk(FacesContext facesContext, DataVisitor dataVisitor, Range range, Object argument) throws IOException
   {
      int firstResult = ((SequenceRange) range).getFirstRow();
      int maxResults = ((SequenceRange) range).getRows();
      List<Equipment> equipments = (List<Equipment>) equipmentService.getAllEquipments(firstResult, maxResults);
      for (Equipment e : equipments)
      {
         Long id = e.getId();
         equipmentMap.put(id, e);
         dataVisitor.process(facesContext, id, argument);
      }
   }

   private Long getSelectedKey()
   {
      if (getSelection() == null || getSelection().size() == 0)
         return null;
      else
         return ((Long) getSelection().getKeys().next());
   }

   public Equipment getSelectedEquipment()
   {
      if (getSelection() != null && getSelection().size() > 0)
         return equipmentMap.get(getSelectedKey());
      else
         return null;
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
