package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import java.util.Collection;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;

/**
 *
 */
public interface EquipmentRepository extends Repository<Equipment, Long>
{
   /**
    * @return All available {@link EquipmentType}s
    */
   public EquipmentType[] getEquipmentTypes();

   Collection<Equipment> findByCriteria(RangeCriteria criteria);
}
