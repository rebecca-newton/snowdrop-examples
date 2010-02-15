package org.jboss.snowdrop.samples.sportsclub.service;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public interface AccountService
{
   /**
    * Get {#link Account} having specific id.
    * @param id
    * @return
    */
   Account getAccountById(long id);

   /**
    * Get all instances of {#link Account}s.
    * @return
    */
   Collection<Account> getAllAccounts();

   /**
    * Filter {#link Account}s according to given parameters.
    * @param min
    * @param max
    * @param nameFragment fragment of subscriber name (first, middle or last name)
    * @return
    */
   List<Account> findAccounts(int min, int max, String nameFragment);

   /**
    * Count number of {#link Account}s according to given parameters.
    * @param min
    * @param max
    * @param nameFragment fragment of subscriber name (first, middle or last name)
    * @return
    */
   Long countAccounts(int min, int max, String nameFragment);

   /**
    * Count number of {#link Account}s according to given parameters.
    * @param nameFragment fragment of subscriber name (first, middle or last name)
    * @return
    */
   Long countAccounts(String nameFragment);
}
