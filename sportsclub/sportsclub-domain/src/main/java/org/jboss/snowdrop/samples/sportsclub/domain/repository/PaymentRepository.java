package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;

import java.util.List;

public interface PaymentRepository extends Repository<Payment, Long>
{
   List<Payment> findForAccount(Account account);
}
