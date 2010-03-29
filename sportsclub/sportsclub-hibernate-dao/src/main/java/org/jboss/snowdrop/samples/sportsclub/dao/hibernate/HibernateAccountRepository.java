package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import static org.hibernate.criterion.Restrictions.*;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.PersonSearchCriteria;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public class HibernateAccountRepository extends HibernateRepository<Account, Long> implements AccountRepository
{

   public HibernateAccountRepository()
   {
      super(Account.class);
   }

   public long countByCriteria(AccountSearchCriteria accountSearchCriteria)
   {
      Criteria criteria = convert(accountSearchCriteria);
      criteria.setProjection(Projections.count("id"));
      return new Long((Integer) criteria.uniqueResult());
   }

   private Criteria convert(AccountSearchCriteria accountSearchCriteria)
   {
      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Account.class);
      if (accountSearchCriteria.isActiveOnly())
      {
         criteria.add(Restrictions.eq("closed", false));
      }
      if (accountSearchCriteria.getPersonSearchCriteria() != null)
      {
         PersonSearchCriteria personSearchCriteria = accountSearchCriteria.getPersonSearchCriteria();
         Criteria personCriteria = criteria.createCriteria("subscriber");
         if (personSearchCriteria.getName() != null)
         {
            personCriteria.add(
                  or(ilike("name.firstName", personSearchCriteria.getName(), MatchMode.ANYWHERE),
                        or(ilike("name.lastName", personSearchCriteria.getName(), MatchMode.ANYWHERE),
                              ilike("name.middleName", personSearchCriteria.getName(), MatchMode.ANYWHERE))));
         }
         if (personSearchCriteria.getCity() != null)
         {
            personCriteria.add(ilike("address.city", personSearchCriteria.getCity(), MatchMode.ANYWHERE));
         }
      }
      if (accountSearchCriteria.getInvoiceSearchCriteria() != null)
      {
         Timestamp now = new Timestamp(accountSearchCriteria.getInvoiceSearchCriteria().getReferenceDate().getTime());
         DetachedCriteria invcEntries = DetachedCriteria.forClass(Invoice.class)
               .setProjection(Property.forName("account.id"));
         invcEntries.add(and(le("billingPeriod.startDate", now), ge("billingPeriod.endDate", now)));

         if (accountSearchCriteria.getInvoiceSearchCriteria().isExistingInvoice())
            criteria.add(Subqueries.propertyIn("id", invcEntries));
         else
            criteria.add(Subqueries.propertyNotIn("id", invcEntries));
      }
      return criteria;
   }

   @SuppressWarnings("unchecked")
   public List<Account> findByCriteria(AccountSearchCriteria accountSearchCriteria)
   {
      Criteria criteria = convert(accountSearchCriteria);
      if (accountSearchCriteria.getRange() != null)
         criteria = applyRange(criteria, accountSearchCriteria.getRange());
      return (List<Account>) criteria.list();
   }
}
