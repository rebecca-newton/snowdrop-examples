package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import java.util.List;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public interface AccountRepository extends Repository<Account, Long>
{
   // TODO if no usages then remove this method!
   List<Account> findByPersonName(String name);

   int countByCriteria(AccountSearchCriteria accountSearchCriteria);

   List<Account> findByCriteria(AccountSearchCriteria accountSearchCriteria);
}
