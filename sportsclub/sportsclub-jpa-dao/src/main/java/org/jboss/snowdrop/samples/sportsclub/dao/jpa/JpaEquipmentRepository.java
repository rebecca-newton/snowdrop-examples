package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Collection;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaEquipmentRepository extends JpaRepository<Equipment,Long> implements EquipmentRepository{

    public JpaEquipmentRepository() {
        super(Equipment.class);
    }

    public EquipmentType[] getEquipmentTypes() {
        return EquipmentType.values();
    }

   @SuppressWarnings("unchecked")
   public Collection<Equipment> findByCriteria(RangeCriteria criteria)
   {
      Query query = entityManager.createQuery("FROM " + Equipment.class.getSimpleName());
      if (criteria.getRange() != null)
         query = applyRange(query, criteria.getRange());
      return query.getResultList();
   }
}
