package org.jboss.snowdrop.samples.sportsclub.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import org.jboss.snowdrop.samples.sportsclub.service.payment.PaymentProcessor;

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
