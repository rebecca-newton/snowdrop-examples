package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class AccountConverter implements Converter
{
   private AccountConverterHelper accountConverterHelper;

   public AccountConverter()
   {
   }

   public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s)
   {
      if (s == null || "".equals(s.trim())) return null;
      Account a;
      try
      {
         a = accountConverterHelper.getAsAccount(s);
      } catch (RuntimeException e)
      {
         throw new ConverterException(e);
      }
      return a;
   }

   public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o)
   {
      if (o == null) return null;
      String s;
      try
      {
         Account a = (Account) o;
         s = accountConverterHelper.getAsString(a);
      }
      catch (RuntimeException e)
      {
         throw new ConverterException(e);
      }
      return s;
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
