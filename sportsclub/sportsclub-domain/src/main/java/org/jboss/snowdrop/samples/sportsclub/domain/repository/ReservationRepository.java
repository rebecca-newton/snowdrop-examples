package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;

import java.util.List;

public interface ReservationRepository extends Repository<Reservation, Long>
{
   List<Reservation> getByCriteria(ReservationSearchCriteria criteria);

   Long countByCriteria(ReservationSearchCriteria criteria);
}
