package org.jboss.snowdrop.samples.sportsclub.jsf.beans;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.service.AccountService;
import org.richfaces.model.selection.Selection;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class AccountFilter extends AbstractExtendedDataModelHelper
{
   private AccountService accountService;

   private String subscriberNameFragment;
   private Map<Long, Account> accountMap = new HashMap<Long, Account>();

   public AccountFilter()
   {
      super();
   }

   public void walk(FacesContext facesContext, DataVisitor dataVisitor, Range range, Object argument) throws IOException
   {
      int firstResult = ((SequenceRange) range).getFirstRow();
      int maxResults = ((SequenceRange) range).getRows();
      List<Account> accounts = accountService.findAccounts(firstResult, maxResults, subscriberNameFragment);
      accountMap = new HashMap<Long, Account>();
      for (Account a : accounts)
      {
         Long id = a.getId();
         accountMap.put(id, a);
         dataVisitor.process(facesContext, id, argument);
      }
   }

   public Map<Long, ? extends Object> getDomainObjectMap()
   {
      return accountMap;
   }

   private Long getSelectedKey()
   {
      if (getSelection() == null || getSelection().size() == 0)
         return null;
      else
         return ((Long) getSelection().getKeys().next());
   }

   public Account getSelectedAccount()
   {
      if (getSelection() != null && getSelection().size() > 0)
         return accountMap.get(getSelectedKey());
      else
         return null;
   }

   public Long getCurrentRowCount()
   {
      return accountService.countAccounts(subscriberNameFragment);
   }

   public String searchAccounts()
   {
      resetCurrentRowCount();
      getRowCount();
      setCurrentPage(1);
      return "success";
   }

   public String getSubscriberNameFragment()
   {
      return subscriberNameFragment;
   }

   public void setSubscriberNameFragment(String subscriberNameFragment)
   {
      this.subscriberNameFragment = subscriberNameFragment;
   }

   public AccountService getAccountService()
   {
      return accountService;
   }

   public void setAccountService(AccountService accountService)
   {
      this.accountService = accountService;
   }
}
