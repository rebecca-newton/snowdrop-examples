package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.ReservationRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.hibernate.Criteria;
import static org.hibernate.criterion.Restrictions.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Disjunction;

import java.util.List;
import java.util.Date;

/**
 */
public class HibernateReservationRepository extends HibernateRepository<Reservation, Long> implements ReservationRepository
{

   public HibernateReservationRepository()
   {
      super(Reservation.class);
   }

   private Criteria convert(ReservationSearchCriteria reservationSearchCriteria)
   {
      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);

      Date from = reservationSearchCriteria.getFromDate();
      Date to = reservationSearchCriteria.getToDate();

      if (from != null && to != null) criteria.add(and(ge("from", from), le("to", to)));
      else
      {
         if (from != null) criteria.add(ge("from", from));
         if (to != null) criteria.add(le("to", to));
      }

      if (reservationSearchCriteria.getRange() != null)
         criteria = applyRange(criteria, reservationSearchCriteria.getRange());

      if (reservationSearchCriteria.getEquipmentType() != null)
      {
         List<EquipmentType> types = reservationSearchCriteria.getEquipmentType();
         if (types.size() > 0)
         {
            Disjunction dis = Restrictions.disjunction();
            for (EquipmentType type : types)
            {
               dis.add(eq("equipmentType",type));
            }
            criteria.createCriteria("equipment").add(dis);
         }

      }
      return criteria;
   }

   public List<Reservation> getByCriteria(ReservationSearchCriteria criteria)
   {
      Criteria cri = convert(criteria);
      return cri.list();
   }

   public Long countByCriteria(ReservationSearchCriteria criteria)
   {
      Criteria cri = convert(criteria);
      cri.setProjection(Projections.count("id"));
      return new Long((Integer)cri.uniqueResult());
   }

}
