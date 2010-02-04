package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.InvoiceSearchCriteria;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaInvoiceRepository extends JpaRepository<Invoice, Long> implements InvoiceRepository
{

   public JpaInvoiceRepository()
   {
      super(Invoice.class);
   }

   public List<Invoice> findForAccount(Account account)
   {
      Query q = entityManager.createQuery("FROM " + Invoice.class.getSimpleName() + " i WHERE i.account.id = :id");
      q.setParameter("id", account.getId());
      return q.getResultList();
   }
}
