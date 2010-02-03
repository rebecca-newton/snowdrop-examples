package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

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
}
