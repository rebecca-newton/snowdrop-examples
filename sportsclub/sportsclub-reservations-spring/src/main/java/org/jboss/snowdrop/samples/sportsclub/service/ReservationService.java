package org.jboss.snowdrop.samples.sportsclub.service;

import java.util.Date;
import java.util.List;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;

/**
 *
 */
public interface ReservationService
{
   List<Reservation> getReservations(Date fromDate, Date toDate, Integer nim, Integer max, List<EquipmentType> types);

   Long countReservationsForRange(Date fromDate, Date toDate, List<EquipmentType> types);

   Reservation create(Reservation reservation);

   public void delete(Reservation reservation);

   public Reservation updateReservation(Reservation reservation);
}
