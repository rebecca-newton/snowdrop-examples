package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.PersonSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

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

   public List<Account> findAccounts(int min, int max, String nameFragment)
   {
      return accountRepository.findByCriteria(getCriteria(min, max, nameFragment));
   }

   public Long countAccounts(int min, int max, String nameFragment)
   {
      return accountRepository.countByCriteria(getCriteria(min, max, nameFragment));
   }

   private AccountSearchCriteria getCriteria(Integer min, Integer max, String nameFragment)
   {
      AccountSearchCriteria criteria = new AccountSearchCriteria();
      if (min != null && max != null) criteria.setRange(new Range(min, max));
      if (nameFragment != null && nameFragment.trim().length() > 0)
      {
         criteria.setPersonSearchCriteria(new PersonSearchCriteria());
         criteria.getPersonSearchCriteria().setName(nameFragment);
      }
      return criteria;
   }

   public Long countAccounts(String nameFragment)
   {
      return accountRepository.countByCriteria(getCriteria(null, null, nameFragment));
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
