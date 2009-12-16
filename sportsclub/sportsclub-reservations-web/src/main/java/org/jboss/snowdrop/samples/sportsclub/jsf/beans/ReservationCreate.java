package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.service.ReservationService;

import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReservationCreate
{
   private ReservationService reservationService;

   private Reservation reservation;

   public void init()
   {
      // reseravtion is for one month starting today
      Calendar cal = Calendar.getInstance(Locale.US);
      cal.clear();
      Date from = cal.getTime(); // now

      cal.setLenient(true);
      int month = cal.get(Calendar.MONTH);
      cal.set(Calendar.MONTH, ++month);
      Date to = cal.getTime(); // next month

      setReservation(new Reservation());
      getReservation().setAccount(new Account());
      getReservation().setEquipment(new Equipment());
      getReservation().setFrom(from);
      getReservation().setTo(to);
   }

   public String create()
   {
      getReservationService().create();
      return "success";
   }

   public Reservation getReservation()
   {
      return reservation;
   }

   public void setReservation(Reservation reservation)
   {
      this.reservation = reservation;
   }

   public ReservationService getReservationService()
   {
      return reservationService;
   }

   public void setReservationService(ReservationService reservationService)
   {
      this.reservationService = reservationService;
   }
}
