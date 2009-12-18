package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class AccountConverter implements Converter
{
   private AccountConverterHelper accountConverterHelper;

   public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
   {
      return null;  //To change body of implemented methods use File | Settings | File Templates.
   }

   public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o)
   {
      return null;  //To change body of implemented methods use File | Settings | File Templates.
   }

   public AccountConverterHelper getAccountConverterHelper()
   {
      return accountConverterHelper;
   }

   public void setAccountConverterHelper(AccountConverterHelper accountConverterHelper)
   {
      this.accountConverterHelper = accountConverterHelper;
   }
}
