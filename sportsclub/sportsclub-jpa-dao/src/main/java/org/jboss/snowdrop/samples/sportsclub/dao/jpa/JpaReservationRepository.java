package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.ReservationRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaReservationRepository extends JpaRepository<Reservation, Long> implements ReservationRepository
{

   public JpaReservationRepository()
   {
      super(Reservation.class);
   }

   public Long countByCriteria(ReservationSearchCriteria criteria)
   {
      Query query = getQuery(criteria, "SELECT count(r.id) ");
      return (Long)query.getSingleResult();
   }

   @SuppressWarnings("unchecked")
   public List<Reservation> getByCriteria(ReservationSearchCriteria criteria)
   {
      Query query = getQuery(criteria, null);
      if (criteria.getRange() != null)
         query = applyRange(query, criteria.getRange());
      return query.getResultList();
   }

   private Query getQuery(ReservationSearchCriteria criteria, String select)
   {
      String q = (select != null ? select : "");
      String fetch = (select == null ? " left join fetch r.equipment" : "");
      
      q += "FROM " + Reservation.class.getSimpleName() + " r" + fetch + " WHERE 1 = 1";

      if (criteria.getFromDate() != null)
      {
         q += " AND r.from >= :from";
      }
      if (criteria.getToDate() != null)
      {
         q += " AND r.to <= :to";
      }
      if (criteria.getEquipmentType() != null && !criteria.getEquipmentType().isEmpty())
      {
         q += " AND r.equipment.equipmentType IN (:equipmentTypes)";
      }

      Query query = entityManager.createQuery(q);

      if (criteria.getFromDate() != null)
      {
         query.setParameter("from", criteria.getFromDate());
      }
      if (criteria.getToDate() != null)
      {
         query.setParameter("to", criteria.getToDate());
      }
      if (criteria.getEquipmentType() != null && !criteria.getEquipmentType().isEmpty())
      {
         query.setParameter("equipmentTypes", criteria.getEquipmentType());
      }
      return query;
   }
}

