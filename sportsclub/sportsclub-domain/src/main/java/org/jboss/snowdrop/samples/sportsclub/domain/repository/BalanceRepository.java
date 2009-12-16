package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;

/**
 * Created by IntelliJ IDEA.
 * User: marius
 * Date: 16-Dec-2009
 * Time: 2:27:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BalanceRepository extends Repository<Balance, Long>
{

   Balance findForAccount(Account account);
}
