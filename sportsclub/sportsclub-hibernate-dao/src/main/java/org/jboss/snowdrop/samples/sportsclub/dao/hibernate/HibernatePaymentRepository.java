package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HibernatePaymentRepository extends HibernateRepository<Payment, Long> implements PaymentRepository
{
   public HibernatePaymentRepository()
   {
      super(Payment.class);
   }

   public List<Payment> findForAccount(Account account)
   {
      Criteria criteria = getCurrentSession().createCriteria(Payment.class);
      criteria.createCriteria("account").add(Restrictions.eq("id", account.getId()));
      return criteria.list();
   }
}
