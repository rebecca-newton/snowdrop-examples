package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaEquipmentRepository extends JpaRepository<Equipment,Long> implements EquipmentRepository{

    public JpaEquipmentRepository() {
        super(Equipment.class); //TODO: create real implementation
    }

    public EquipmentType[] getEquipmentTypes() {
        return new EquipmentType[0]; //TODO: create real implementation
    }
}
