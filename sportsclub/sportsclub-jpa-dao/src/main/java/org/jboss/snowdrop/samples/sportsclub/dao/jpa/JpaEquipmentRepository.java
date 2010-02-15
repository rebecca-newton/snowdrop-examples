package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

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

   public Collection<Equipment> findByCriteria(RangeCriteria criteria)
   {
      Query q = entityManager.createQuery("FROM " + Equipment.class.getSimpleName());
      List<Equipment> list = q.getResultList();
      if (criteria.getRange() != null)
      {
         int max = (criteria.getRange().getMaxIndex() > list.size() ? list.size() : criteria.getRange().getMaxIndex());
         list = list.subList(criteria.getRange().getMinIndex(), max);
      }
      return list;
   }
}
