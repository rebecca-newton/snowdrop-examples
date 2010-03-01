package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.service.ReservationService;
import org.richfaces.model.selection.Selection;
import org.richfaces.model.selection.SimpleSelection;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReservationSearch extends AbstractExtendedDataModelHelper
{
   private ReservationService reservationService;
   private ReservationSearchOptions reservationSearchOptions;

   private Map<Long, Reservation> reservationsMap = new HashMap<Long, Reservation>();

   private ReservationTableState tableState;

   private AccountFilter accountFilter;
   private EquipmentFilter equipmentFilter;
   private Locale locale = Locale.getDefault();

   private boolean editing;

   public ReservationSearch()
   {
      super();
   }

   public ReservationService getReservationService()
   {
      return reservationService;
   }

   public void setReservationService(ReservationService reservationService)
   {
      this.reservationService = reservationService;
   }

   @Override
   public Map<Long,? extends Object> getDomainObjectMap()
   {
      return reservationsMap;
   }

   @Override
   public Long getCurrentRowCount()
   {
      return reservationService.countReservationsForRange(
               reservationSearchOptions.getFromDate(),
               reservationSearchOptions.getToDate(),
               reservationSearchOptions.getSelectedEquipmentTypes());
   }

   @Override
   public void walk(FacesContext facesContext, DataVisitor dataVisitor, Range range, Object argument) throws IOException
   {
      int firstResult = ((SequenceRange) range).getFirstRow();
      int maxResults = ((SequenceRange) range).getRows();
      List<Reservation> list = reservationService.getReservations(
            reservationSearchOptions.getFromDate(),
            reservationSearchOptions.getToDate(), firstResult, maxResults,
            reservationSearchOptions.getSelectedEquipmentTypes());
      reservationsMap = new HashMap<Long, Reservation>();
      for (Reservation row : list)
      {
         Long id = row.getId();
         reservationsMap.put(id, row);
         dataVisitor.process(facesContext, id, argument);
      }
   }

   public String equipmentTypeCheckboxChanged()
   {
      return null; // TODO ?
   }

   public ReservationTableState getTableState()
   {
      return tableState;
   }

   public void setTableState(ReservationTableState tableState)
   {
      this.tableState = tableState;
   }

   public ReservationSearchOptions getReservationSearchOptions()
   {
      return reservationSearchOptions;
   }

   public void setReservationSearchOptions(ReservationSearchOptions reservationSearchOptions)
   {
      this.reservationSearchOptions = reservationSearchOptions;
   }

   private Long getSelectedKey()
   {
      if (getSelection() == null || getSelection().size() == 0)
         return null;
      else
         return ((Long) getSelection().getKeys().next());
   }

   public Reservation getCurrentReservation()
   {
      if (getSelection() != null && getSelection().size() > 0)
         return reservationsMap.get(getSelectedKey());
      else
         return null;
   }

   public String deleteReservation()
   {
      reservationService.delete(getCurrentReservation());
      setSelection(new SimpleSelection());
      resetCurrentRowCount();
      return "closed";
   }

   public void saveCurrent()
   {
      reservationService.updateReservation(getCurrentReservation());
      setSelection(new SimpleSelection());
      editing = false;
   }

   public void updateSelectedAccount()
   {
      Account account = accountFilter.getSelectedAccount();
      //reservation.setAccount(account);
   }

   public void updateSelectedEquipment()
   {
      Equipment equipment = equipmentFilter.getSelectedEquipment();
      //reservation.setEquipment(equipment);
   }

   public void setEditing(boolean editing)
   {
      this.editing = editing;
   }

   public boolean isEditing()
   {
      return editing;
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

   public Locale getLocale()
   {
      return locale;
   }

   public void setLocale(Locale locale)
   {
      this.locale = locale;
   }
}
