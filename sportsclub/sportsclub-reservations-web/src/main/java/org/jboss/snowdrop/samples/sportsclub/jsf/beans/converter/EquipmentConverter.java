package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;

import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class EquipmentConverter implements Converter
{

   private EquipmentConverterHelper equipmentConverterHelper;

   public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
   {
      if (s == null || "".equals(s.trim())) return null;
      Equipment eqp;
      try
      {
         eqp = equipmentConverterHelper.getAsEquipment(s);
      } catch (RuntimeException e)
      {
         throw new ConverterException(e);
      }
      return eqp;
   }

   public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o)
   {
      if (o == null) return null;
      String s;
      try {
         Equipment e = (Equipment)o;
         s = equipmentConverterHelper.getAsString(e);
      }
      catch (RuntimeException e)
      {
         throw new ConverterException(e);
      }
      return s;
   }

   public EquipmentConverterHelper getEquipmentConverterHelper()
   {
      return equipmentConverterHelper;
   }

   public void setEquipmentConverterHelper(EquipmentConverterHelper equipmentConverterHelper)
   {
      this.equipmentConverterHelper = equipmentConverterHelper;
   }
}
