package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.service.ReservationService;
import org.jboss.snowdrop.samples.sportsclub.service.AccountService;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;

import javax.faces.model.SelectItem;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.Collection;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReservationCreate
{
   private AccountFilter accountFilter;
   private EquipmentFilter equipmentFilter;

   private ReservationService reservationService;
   private AccountService accountService;

   private Reservation reservation;
   private long createdReservationId;

   public void init()
   {
      Date from;
      Date to;

      Calendar cal = Calendar.getInstance(Locale.US);
      //cal.clear();
      from = cal.getTime();

      cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
      to = cal.getTime();

      reservation = new Reservation();
      reservation.setAccount(null);
      reservation.setEquipment(null);
      reservation.setFrom(from);
      reservation.setTo(to);
   }

   public String create()
   {
      reservationService.create(reservation);
      createdReservationId = reservation.getId();
      init();
      return "success";
   }

   public void updateSelectedAccount()
   {
      Account account = accountFilter.getSelectedAccount();
      reservation.setAccount(account);
   }

   public void updateSelectedEquipment()
   {
      Equipment equipment = getEquipmentFilter().getSelectedEquipment();
      reservation.setEquipment(equipment);
   }

   public ReservationService getReservationService()
   {
      return reservationService;
   }

   public void setReservationService(ReservationService reservationService)
   {
      this.reservationService = reservationService;
   }

   public Reservation getReservation()
   {
      return reservation;
   }

   public void setReservation(Reservation reservation)
   {
      this.reservation = reservation;
   }

   public AccountService getAccountService()
   {
      return accountService;
   }

   public void setAccountService(AccountService accountService)
   {
      this.accountService = accountService;
   }

   public AccountFilter getAccountFilter()
   {
      return accountFilter;
   }

   public void setAccountFilter(AccountFilter accountFilter)
   {
      this.accountFilter = accountFilter;
   }

   public EquipmentFilter getEquipmentFilter()
   {
      return equipmentFilter;
   }

   public void setEquipmentFilter(EquipmentFilter equipmentFilter)
   {
      this.equipmentFilter = equipmentFilter;
   }

   public long getCreatedReservationId()
   {
      return createdReservationId;
   }

   public void setCreatedReservationId(long createdReservationId)
   {
      this.createdReservationId = createdReservationId;
   }
}
