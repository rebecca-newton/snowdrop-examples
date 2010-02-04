package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.sportsclub.service.ReservationService;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;

import javax.faces.context.FacesContext;
import java.util.*;
import java.io.IOException;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class ReservationSearch extends ExtendedDataModel
{

   private ReservationService reservationService;

   private ReservationSearchOptions reservationSearchOptions;

   private int currentPage;
   private int currentRow;
   private Long currentId;

   private Map<Long, Reservation> reservationsMap = new HashMap<Long, Reservation>();
   private Long rowCount;

   private ReservationTableState tableState;

   public   ReservationSearch() {
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

   public int getCurrentPage()
   {
      return currentPage;
   }

   public void setCurrentPage(int currentPage)
   {
      this.currentPage = currentPage;
   }

   @Override
   public Object getRowKey()
   {
      return currentId;
   }

   @Override
   public void setRowKey(Object key)
   {
      if (key != null)
         currentId = (Long) key;
   }

   @Override
   public boolean isRowAvailable()
   {
      if (currentId == null)
         return false;
      if (reservationsMap.containsKey(currentId))
         return true;
      return false;
   }

   @Override
   public int getRowCount()
   {
      if (rowCount == null)
      {
         rowCount = reservationService.countReservationsForRange(
               reservationSearchOptions.getFromDate(),
               reservationSearchOptions.getToDate(),
               reservationSearchOptions.getSelectedEquipmentTypes());
      }
      return rowCount.intValue();
   }

   @Override
   public Object getRowData()
   {
      return reservationsMap.get(currentId);
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

   @Override
   public int getRowIndex()
   {
      return currentRow;
   }

   @Override
   public void setRowIndex(int rowIndex)
   {
      this.currentRow = rowIndex;
   }

   @Override
   public Object getWrappedData()
   {
      throw new UnsupportedOperationException("Not supported");
   }

   @Override
   public void setWrappedData(Object data)
   {
      throw new UnsupportedOperationException("Not supported");
   }

   public String equipmentTypeCheckboxChanged() {
      return null;
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
}
