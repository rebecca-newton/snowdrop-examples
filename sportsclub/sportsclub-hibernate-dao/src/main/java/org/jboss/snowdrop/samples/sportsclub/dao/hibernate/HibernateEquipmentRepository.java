package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.hibernate.Criteria;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;

import java.util.Collection;

public class HibernateEquipmentRepository extends HibernateRepository<Equipment, Long> implements EquipmentRepository
{

   public HibernateEquipmentRepository()
   {
      super(Equipment.class);
   }

   public EquipmentType[] getEquipmentTypes()
   {
      return EquipmentType.values();
   }

   public Collection<Equipment> findByCriteria(RangeCriteria rangeCriteria)
   {
      Criteria criteria = convert(rangeCriteria);
      return criteria.list();
   }

   private Criteria convert(RangeCriteria rangeCriteria)
   {
      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Equipment.class);
      if (rangeCriteria.getRange() != null)
      {
         criteria.setFirstResult(rangeCriteria.getRange().getMinIndex());
         criteria.setMaxResults(rangeCriteria.getRange().length());
      }
      return criteria;
   }
}
