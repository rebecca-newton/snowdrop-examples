package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;

import javax.faces.convert.EnumConverter;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class EquipmentTypeConverter extends EnumConverter
{
   public EquipmentTypeConverter()
   {
      super(EquipmentType.class);
   }
}
