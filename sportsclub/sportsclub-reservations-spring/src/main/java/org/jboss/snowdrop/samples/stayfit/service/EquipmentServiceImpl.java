package org.jboss.snowdrop.samples.stayfit.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class EquipmentServiceImpl  implements EquipmentService
{
   private EquipmentRepository equipmentRepository;

   public EquipmentType[] getEquipmentTypes()
   {
      return equipmentRepository.getEquipmentTypes();
   }

   public EquipmentRepository getEquipmentRepository()
   {
      return equipmentRepository;
   }

   public void setEquipmentRepository(EquipmentRepository equipmentRepository)
   {
      this.equipmentRepository = equipmentRepository;
   }
}
