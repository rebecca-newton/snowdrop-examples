package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaAccountRepository extends JpaRepository<Account, Long> implements AccountRepository
{

   public JpaAccountRepository()
   {
      super(Account.class);
   }

   public long countByCriteria(AccountSearchCriteria accountSearchCriteria)
   {
      Query query = getQuery(accountSearchCriteria, "SELECT count(a.id) ");
      return (Long)query.getSingleResult();
   }

   @SuppressWarnings("unchecked")
   public List<Account> findByCriteria(AccountSearchCriteria criteria)
   {
      Query query = getQuery(criteria, null);
      if (criteria.getRange() != null)
         query = applyRange(query, criteria.getRange());
      return (List<Account>)query.getResultList();
   }

   private Query getQuery(AccountSearchCriteria criteria, String select)
   {
      String q = (select != null ? select : "");

      q += "FROM " + Account.class.getSimpleName() + " a WHERE 1 = 1";

      if (criteria.isActiveOnly())
      {
         q += " AND a.closed = :active";
      }
      if (criteria.getPersonSearchCriteria() != null
            && criteria.getPersonSearchCriteria().getName() != null
            && criteria.getPersonSearchCriteria().getName().trim().length() != 0)
      {
         q += " AND (a.subscriber.name.firstName like :name" +
              " OR a.subscriber.name.lastName like :name" +
              " OR a.subscriber.name.middleName like :name)";
      }
      if (criteria.getPersonSearchCriteria() != null && criteria.getPersonSearchCriteria().getCity() != null)
      {
         q += " AND a.subscriber.address.city like :city";
      }
      if (criteria.getInvoiceSearchCriteria() != null)
      {
         String not = (!criteria.getInvoiceSearchCriteria().isExistingInvoice() ? "NOT" : "");
         q += " AND a.id "+not+" IN (SELECT i.account.id FROM " + Invoice.class.getSimpleName() +
              " i WHERE :now between i.billingPeriod.startDate and i.billingPeriod.endDate )";
      }

      Query query = entityManager.createQuery(q);

      if (criteria.isActiveOnly())
      {
         query.setParameter("active", false);
      }
      if (criteria.getPersonSearchCriteria() != null
            && criteria.getPersonSearchCriteria().getName() != null
            && criteria.getPersonSearchCriteria().getName().trim().length() != 0)
      {
         query.setParameter("name", "%" + criteria.getPersonSearchCriteria().getName() + "%");
      }
      if (criteria.getPersonSearchCriteria() != null && criteria.getPersonSearchCriteria().getCity() != null)
      {
         query.setParameter("city", "%" + criteria.getPersonSearchCriteria().getCity() + "%");
      }
      if (criteria.getInvoiceSearchCriteria() != null && criteria.getInvoiceSearchCriteria().getReferenceDate() != null)
      {
         query.setParameter("now", criteria.getInvoiceSearchCriteria().getReferenceDate());
      }

      return query;
   }
}
