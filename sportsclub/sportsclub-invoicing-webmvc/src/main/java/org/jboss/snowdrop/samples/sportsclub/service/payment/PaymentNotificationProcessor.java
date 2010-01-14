package org.jboss.snowdrop.samples.sportsclub.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.PaymentNotification;

/**
 * @author Marius Bogoevici
 */
@Component
public class PaymentNotificationProcessor
{

   @Autowired
   private PaymentProcessor paymentProcessor;

   public void processPaymentNotification(PaymentNotification paymentNotification)
   {
      paymentProcessor.processPayment(paymentNotification.getAccountNumber(), paymentNotification.getAmount());
   }

}
