package org.jboss.snowdrop.samples.sportsclub.messaging;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.PaymentNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author Marius Bogoevici
 */
@ManagedResource(objectName = "sportsclub:name=paymentNotificationTrigger", description = "Payment Notification Trigger")
@Component
public class PaymentTrigger
{

   private static final Log LOG = LogFactory.getLog(PaymentTrigger.class);

   @Autowired
   private JmsTemplate jmsTemplate;

   @ManagedOperation(description = "Send Payment Notification")
   public void sendPaymentNotification(
         @ManagedOperationParameter(name="accountId", description= "The account for which the payment is made") Long accountId,
         @ManagedOperationParameter(name="amount", description= "Payment amount") double amount)
   {
      PaymentNotification paymentNotification = new PaymentNotification();
      paymentNotification.setAccountNumber(accountId);
      paymentNotification.setAmount(BigDecimal.valueOf(amount));
      jmsTemplate.convertAndSend(paymentNotification);
      LOG.info(paymentNotification + " sent to message queue");
   }
}
