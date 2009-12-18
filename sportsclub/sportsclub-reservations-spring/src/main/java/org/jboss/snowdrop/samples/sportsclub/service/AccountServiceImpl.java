package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService
{
   private AccountRepository accountRepository;

   public Account getAccountById(long id)
   {
      return accountRepository.findById(id);
   }

   public Collection<Account> getAllAccounts()
   {
      return accountRepository.findAll();
   }

   public AccountRepository getAccountRepository()
   {
      return accountRepository;
   }

   public void setAccountRepository(AccountRepository accountRepository)
   {
      this.accountRepository = accountRepository;
   }
   
}
