package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.service.AccountService;
import org.jboss.snowdrop.samples.sportsclub.service.ReservationService;

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
   private Long createdReservationId;
   private Locale locale;

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

      locale = Locale.getDefault();
   }

   public Locale getLocale()
   {
      return locale;
   }

   public String create()
   {
      Map<String, FacesMessage> errorMessages = validate(reservation);

      if (!errorMessages.isEmpty())
      {
         FacesContext context = FacesContext.getCurrentInstance();
         for (String key : errorMessages.keySet())
         {
            context.addMessage(key, errorMessages.get(key));
         }
         return "error";
      }

      reservation = reservationService.create(reservation);
      createdReservationId = reservation.getId();
      init();
      accountFilter.setSelection(null);
      equipmentFilter.setSelection(null);

      return "success";
   }

   private Map<String, FacesMessage> validate(Reservation reservation)
   {

      Map<String, FacesMessage> errors = new HashMap<String, FacesMessage>();

      if (reservation.getAccount() == null ||
            reservation.getEquipment() == null ||
            reservation.getFrom() == null ||
            reservation.getTo() == null)
      {

         if (reservation.getAccount() == null)
         {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Account not selected.");
            message.setDetail("Please select account!");
            errors.put("AccountSelectForm", message);
         }

         if (reservation.getEquipment() == null)
         {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Equipment not selected.");
            message.setDetail("Please select equipment!");
            errors.put("EquipmentSelectForm", message);
         }

         if (reservation.getFrom() == null)
         {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Date not selected.");
            message.setDetail("Please select date!");
            errors.put("ReservationDetailForm:from", message);
         }

         if (reservation.getTo() == null)
         {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Date not selected.");
            message.setDetail("Please select date!");
            errors.put("ReservationDetailForm:to", message);
         }
      }

      return errors;
   }

   public void updateSelectedAccount()
   {
      Account account = accountFilter.getSelectedAccount();
      reservation.setAccount(account);
   }

   public void updateSelectedEquipment()
   {
      Equipment equipment = equipmentFilter.getSelectedEquipment();
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
