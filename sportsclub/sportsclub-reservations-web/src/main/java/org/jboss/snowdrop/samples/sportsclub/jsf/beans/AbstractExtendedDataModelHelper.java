package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.DataVisitor;
import org.richfaces.model.selection.Selection;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Map;

/**
 * Abstract helper class for JSF backing beans serving {#link ExtendedDataModel} implementations. 
 *
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public abstract class AbstractExtendedDataModelHelper extends ExtendedDataModel
{
   private int currentPage;
   private int currentRow;
   private Long currentId;
   private Long currentRowCount;
   private Selection selection;

   abstract public Map<Long,? extends Object> getDomainObjectMap();

   abstract public Long getCurrentRowCount();

   public Long getCurrentId()
   {
      return currentId;
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

   @Override
   public int getRowCount()
   {
      if (currentRowCount == null)
      {
         currentRowCount = getCurrentRowCount();
      }
      return currentRowCount.intValue();
   }

   /**
    * Implementing // TODO
    */
   public void resetCurrentRowCount()
   {
      currentRowCount = null;
   }

   @Override
   public Object getRowData()
   {
      return getDomainObjectMap().get(currentId);
   }

   @Override
   public boolean isRowAvailable()
   {
      if (currentId == null)
         return false;
      if (getDomainObjectMap().containsKey(currentId))
         return true;
      return false;
   }

   public int getCurrentPage()
   {
      return currentPage;
   }

   public void setCurrentPage(int currentPage)
   {
      this.currentPage = currentPage;
   }

   public Selection getSelection()
   {
      return selection;
   }

   public void setSelection(Selection selection)
   {
      System.out.println("Setting selection " + selection);
      this.selection = selection;
   }
}
