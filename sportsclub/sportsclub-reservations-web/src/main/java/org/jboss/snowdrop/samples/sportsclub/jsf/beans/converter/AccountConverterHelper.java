package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.service.AccountService;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class AccountConverterHelper
{

   private AccountService accountService;

   public String getAsString(Account a)
   {
      String s = a.getId() + " " + a.getSubscriber().getName().getFirstName() + " " +
            a.getSubscriber().getName().getLastName() + " (" +
            a.getSubscriber().getAddress().getCity() + ", " +
            a.getSubscriber().getAddress().getCountry() + ")";
      return s;
   }

   public Account getAsAccount(String s)
   {
      String[] items = s.split(" ",2);
      Account a = accountService.getAccountById(Long.decode(items[0]));
      return a;
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
