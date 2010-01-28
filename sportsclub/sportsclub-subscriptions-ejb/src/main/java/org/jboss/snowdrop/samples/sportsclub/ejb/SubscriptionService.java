package org.jboss.snowdrop.samples.sportsclub.ejb;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.BillingType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;

import javax.ejb.Local;
import java.util.List;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
@Local
public interface SubscriptionService
{
   int countAccountsBySubscriberName(String name);

   /**
    * Search for {@link org.jboss.snowdrop.samples.sportsclub.domain.entity.Account}s
    * based on provided subscriber name fragment. minIndex and maxIndex parameters
    * are to allow results pagination. 
    *
    * @param name       subscriber name fragment
    * @param minIndex   start of result index
    * @param maxIndex   end of result index
    * @return           list of related accounts
    */
   List<Account> findAccountsBySubscriberName(String name, int minIndex, int maxIndex);

   /**
    * Search for {@link org.jboss.snowdrop.samples.sportsclub.domain.entity.Account}s
    * based on provided subscriber name fragment. minIndex and maxIndex parameters
    * are to allow results pagination, currentInvoice flag means whether related
    * accounts have opened/active invoice or not.
    *
    * @see #findAccountsBySubscriberName(String, int, int)
    *
    * @param name             subscriber name fragment
    * @param minIndex         start of result index
    * @param maxIndex         end of result index
    * @param currentInvoice   active invoice
    * @return                 list of related accounts
    */
   List<Account> findAccountsBySubscriberName(String name, int minIndex, int maxIndex, boolean currentInvoice);

   List<String> getMembershipTypes();

   Account createAccount(Person person, String membershipCode, BillingType billingType);

   Account findAccountById(Long id);

   void closeAccount(Account account);

   void updateAccount(Account currentAccount);
}
