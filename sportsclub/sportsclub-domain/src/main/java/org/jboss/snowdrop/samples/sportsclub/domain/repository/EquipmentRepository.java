package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;

import java.util.List;
import java.util.Date;

/**
 *
 */
public interface EquipmentRepository extends Repository<Equipment, Long>
{
   public List<Equipment> getAvailableEquipments(Date fromDate, Date toDate);

   /**
    * @return All available {@link EquipmentType}
    */
   public EquipmentType[] getEquipmentTypes();

}
