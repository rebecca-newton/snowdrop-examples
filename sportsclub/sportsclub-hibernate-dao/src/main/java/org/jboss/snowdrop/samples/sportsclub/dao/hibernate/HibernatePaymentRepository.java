package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.PaymentRepository;

public class HibernatePaymentRepository extends HibernateRepository<Payment, Long> implements PaymentRepository
{
   public HibernatePaymentRepository()
   {
      super(Payment.class);
   }
}
