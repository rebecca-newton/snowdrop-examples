package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Balance;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.BalanceRepository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class HibernateBalanceRepository extends HibernateRepository<Balance,Long> implements BalanceRepository
{
   public HibernateBalanceRepository()
   {
      super(Balance.class);
   }

   public Balance findForAccount(Account account)
   {
      Criteria criteria = getCurrentSession().createCriteria(Payment.class);
      criteria.createCriteria("account").add(Restrictions.eq("id", account.getId()));
      Balance balance = (Balance) criteria.uniqueResult();
      if (balance == null)
      {
         balance = new Balance();
         balance.setAccount(account);
         balance.setCurrentBalance(BigDecimal.ZERO);
      }
      return balance;
   }
}
