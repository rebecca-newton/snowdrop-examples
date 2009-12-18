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
      return String.valueOf(a.getId());
   }

   public Account getAsAccount(String s)
   {
      Account a = accountService.getAccountById(Long.decode(s));
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
