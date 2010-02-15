package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;

import java.util.List;
import java.util.Date;
import java.util.Collection;

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
