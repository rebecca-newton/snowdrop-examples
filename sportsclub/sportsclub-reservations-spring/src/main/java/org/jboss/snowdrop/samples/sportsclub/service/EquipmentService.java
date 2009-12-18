package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;

import java.util.Collection;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public interface EquipmentService
{
   public EquipmentType[] getEquipmentTypes();

   public Equipment findEquipmentById(long id);

   public Collection<Equipment> getAllEquipments();
}
