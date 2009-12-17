package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;

import java.util.List;
import java.util.Date;

public class HibernateEquipmentRepository extends HibernateRepository<Equipment, Long> implements EquipmentRepository
{

   public HibernateEquipmentRepository()
   {
      super(Equipment.class);
   }

   public List<Equipment> getAvailableEquipments(Date fromDate, Date toDate)
   {
      // TODO implement fancy query
      return null;
   }

   public EquipmentType[] getEquipmentTypes()
   {
      return EquipmentType.values();
   }
}
