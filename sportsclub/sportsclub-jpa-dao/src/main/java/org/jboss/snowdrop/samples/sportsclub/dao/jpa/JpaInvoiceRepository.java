package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

   @SuppressWarnings("unchecked")
   public List<Invoice> findForAccount(Account account)
   {
      Query query = entityManager.createQuery("FROM " + Invoice.class.getSimpleName() + " i WHERE i.account.id = :id");
      query.setParameter("id", account.getId());
      return query.getResultList();
   }
}
