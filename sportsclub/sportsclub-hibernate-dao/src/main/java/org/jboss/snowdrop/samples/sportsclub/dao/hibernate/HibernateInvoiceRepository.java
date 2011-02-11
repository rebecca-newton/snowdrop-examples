package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;

import java.util.List;

public class HibernateInvoiceRepository extends HibernateRepository<Invoice, Long> implements InvoiceRepository
{
   public HibernateInvoiceRepository()
   {
      super(Invoice.class);
   }

   @SuppressWarnings("unchecked")
   public List<Invoice> findForAccount(Account account)
   {
      Criteria criteria = getCurrentSession().createCriteria(Invoice.class);
      criteria.createCriteria("account").add(Restrictions.eq("id", account.getId()));
      return criteria.list();
   }
}

