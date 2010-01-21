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

   List<Account> findAccountsBySubscriberName(String name, int minIndex, int maxIndex);

   List<String> getMembershipTypes();

   Account createAccount(Person person, String membershipCode, BillingType billingType);

   Account findAccountById(Long id);

   void closeAccount(Account account);

   void updateAccount(Account currentAccount);
}
