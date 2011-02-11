package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaPaymentRepository extends JpaRepository<Payment, Long> implements PaymentRepository
{
   public JpaPaymentRepository()
   {
      super(Payment.class);
   }

   @SuppressWarnings("unchecked")
   public List<Payment> findForAccount(Account account)
   {
      Query query = entityManager.createQuery("FROM " + Payment.class.getSimpleName() + " p WHERE p.account.id = :id");
      query.setParameter("id", account.getId());
      return query.getResultList();
   }
}
