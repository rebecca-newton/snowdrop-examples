package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class HibernateInvoiceRepository extends HibernateRepository<Invoice, Long> implements InvoiceRepository
{
   public HibernateInvoiceRepository()
   {
      super(Invoice.class);
   }

   public List<Invoice> findForAccount(Account account)
   {
      Criteria criteria = getCurrentSession().createCriteria(Invoice.class);
      criteria.createCriteria("account").add(Restrictions.eq("id", account.getId()));
      return ((List<Invoice>) criteria.list());
   }
}

