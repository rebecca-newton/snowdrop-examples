package org.jboss.snowdrop.samples.sportsclub.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;

import org.jboss.snowdrop.samples.sportsclub.payment.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Marius Bogoevici
 */
@WebService
public class PaymentNotificationService extends SpringBeanAutowiringSupport
{

   @Autowired
   private PaymentProcessor paymentProcessor;

   @WebMethod
   public Long notifyPayment(Long accountNumber, BigDecimal amount)
   {
      return paymentProcessor.processPayment(accountNumber, amount);
   }


}
