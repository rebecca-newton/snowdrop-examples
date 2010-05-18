package org.jboss.snowdrop.samples.sportsclub.messaging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.snowdrop.samples.sportsclub.payment.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.PaymentNotification;

/**
 * @author Marius Bogoevici
 */
@Component
public class PaymentNotificationProcessor
{
   private static final Log LOG = LogFactory.getLog(PaymentNotificationProcessor.class);

   @Autowired
   private PaymentProcessor paymentProcessor;

   public void processPaymentNotification(PaymentNotification paymentNotification)
   {
      LOG.info(paymentNotification + " received");
      paymentProcessor.processPayment(paymentNotification.getAccountNumber(), paymentNotification.getAmount());
      LOG.info(paymentNotification + " processed");

   }

}
