package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.ReservationRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

/**
 *
 */
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService
{

   private ReservationRepository reservationRepository;

   public List<Reservation> getReservations(Date fromDate, Date toDate, Integer min, Integer max, List<EquipmentType> types)
   {
      ReservationSearchCriteria criteria = new ReservationSearchCriteria();
      criteria.setFromDate(fromDate);
      criteria.setToDate(toDate);
      if (min != null && max != null)
      {
         Range range = new Range(min, max);
         criteria.setRange(range);
      }
      if (types != null && types.size() > 0)
      {
         criteria.setEquipmentType(types);
      }
      return reservationRepository.getByCriteria(criteria);
   }

   public Integer countReservationsForRange(Date fromDate, Date toDate, List<EquipmentType> types)
   {
      ReservationSearchCriteria criteria = new ReservationSearchCriteria();
      criteria.setFromDate(fromDate);
      criteria.setToDate(toDate);
      if (types != null && types.size() > 0)
      {
         criteria.setEquipmentType(types);
      }
      return reservationRepository.countByCriteria(criteria);
   }

   @Transactional(readOnly = false)
   public void create(Reservation reservation)
   {
      reservationRepository.save(reservation);
   }

   public ReservationRepository getReservationRepository()
   {
      return reservationRepository;
   }

   public void setReservationRepository(ReservationRepository reservationRepository)
   {
      this.reservationRepository = reservationRepository;
   }

}
