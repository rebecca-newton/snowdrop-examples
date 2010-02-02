package org.jboss.snowdrop.samples.sportsclub.springmvc;

import java.math.BigDecimal;

import javax.ejb.EJB;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.PaymentNotification;
import org.jboss.snowdrop.samples.sportsclub.ejb.SubscriptionService;
import org.jboss.spring.samples.sportsclub.invoicing.services.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController
{
   @EJB(mappedName = "sportsclub/BillingService")
   BillingService billingService;

   @EJB(mappedName = "sportsclub/SubscriptionService")
   SubscriptionService subscriptionService;

   @Autowired
   private JmsTemplate jmsTemplate;

   @RequestMapping("/executePayment.do")
   ModelAndView doSomething(@RequestParam("accountId") Long accountId, @RequestParam("amount") double amount)
   {
      PaymentNotification paymentNotification = new PaymentNotification();
      paymentNotification.setAccountNumber(accountId);
      paymentNotification.setAmount(BigDecimal.valueOf(amount));
      jmsTemplate.convertAndSend(paymentNotification);
      return new ModelAndView("paymentNotification", "amount", amount);
   }
}
