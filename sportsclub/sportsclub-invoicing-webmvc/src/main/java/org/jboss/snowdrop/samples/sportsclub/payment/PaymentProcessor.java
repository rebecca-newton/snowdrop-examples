package org.jboss.snowdrop.samples.sportsclub.payment;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marius Bogoevici
 */
public interface PaymentProcessor
{
   @Transactional
   Long processPayment(Long accountId, BigDecimal amount);
}
