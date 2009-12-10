package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.jboss.snowdrop.samples.stayfit.service.ReservationService;
import org.jboss.snowdrop.samples.stayfit.service.EquipmentService;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.util.*;
import java.io.IOException;

/**
 */
public class ReservationSearch extends ExtendedDataModel
{

   private ReservationService reservationService;
   private EquipmentService equipmentService;
   private Date fromDate;
   private Date toDate;

   private List<EquipmentType> selectedEquipmentTypes;

   private int currentPage;
   private int currentRow;
   private Long currentId;

   private Map<Long, Reservation> reservationsMap = new HashMap<Long, Reservation>();
   private Integer rowCount;

   public void init() {
      selectedEquipmentTypes = Arrays.asList(equipmentService.getEquipmentTypes());
   }

   public String searchReservations()
   {
      rowCount = reservationService.countReservationsForRange(fromDate, toDate, selectedEquipmentTypes);
      currentPage = 0;
      return "success";
   }


   public ReservationService getReservationService()
   {
      return reservationService;
   }

   public void setReservationService(ReservationService reservationService)
   {
      this.reservationService = reservationService;
   }

   public Date getFromDate()
   {
      return fromDate;
   }

   public void setFromDate(Date fromDate)
   {
      this.fromDate = fromDate;
   }

   public Date getToDate()
   {
      return toDate;
   }

   public void setToDate(Date toDate)
   {
      this.toDate = toDate;
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
         rowCount = reservationService.countReservationsForRange(fromDate, toDate, selectedEquipmentTypes);
      }
      return rowCount;
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
      List<Reservation> list = reservationService.getReservations(fromDate, toDate, firstResult, maxResults, selectedEquipmentTypes);
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

   public List<EquipmentType> getSelectedEquipmentTypes()
   {
      return selectedEquipmentTypes;
   }

   public void setSelectedEquipmentTypes(List<EquipmentType> selectedEquipmentTypes)
   {
      System.out.println("setSelectedEquipmentTypes");
      for (EquipmentType e : selectedEquipmentTypes)
      {
         System.out.println("************************************ > " + e);
      }
      this.selectedEquipmentTypes = selectedEquipmentTypes;
   }

   public String equipmentTypeCheckboxChanged() {
      System.out.println("equipmentTypeCheckboxChanged");
      return null;
   }

   public EquipmentService getEquipmentService()
   {
      return equipmentService;
   }

   public void setEquipmentService(EquipmentService equipmentService)
   {
      this.equipmentService = equipmentService;
   }
}
