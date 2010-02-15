package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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

   public Collection<Equipment> getAllEquipments()
   {
      return equipmentRepository.findAll();
   }

   public Long countAllEquipments()
   {
      return equipmentRepository.countAll();
   }

   public Collection<Equipment> getAllEquipments(int firstResult, int maxResults)
   {
      RangeCriteria criteria = new RangeCriteria();
      criteria.setRange(new Range(firstResult, maxResults));
      return equipmentRepository.findByCriteria(criteria);
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
