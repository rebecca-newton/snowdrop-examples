package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@Transactional(readOnly = true)
public class EquipmentServiceImpl  implements EquipmentService
{
   private EquipmentRepository equipmentRepository;

   public EquipmentType[] getEquipmentTypes()
   {
      return equipmentRepository.getEquipmentTypes();
   }

   public Equipment findEquipmentById(long id)
   {
      return equipmentRepository.findById(id);
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
