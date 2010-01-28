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
import org.springframework.web.servlet.ModelAndView;

@Controller
@Deprecated
public class BasicController
{
   @EJB(mappedName = "sportsclub/BillingService")
   BillingService billingService;

   @EJB(mappedName = "sportsclub/SubscriptionService")
   SubscriptionService subscriptionService;

   @Autowired
   private JmsTemplate jmsTemplate;

   @RequestMapping("/basic.do")
   ModelAndView doSomething()
   {
      Account account = subscriptionService.findAccountsBySubscriberName("Vimes", 0, 1).get(0);
      Invoice invoice = billingService.generateInvoice(account);
      PaymentNotification paymentNotification = new PaymentNotification();
      paymentNotification.setAccountNumber(account.getId());
      paymentNotification.setAmount(BigDecimal.valueOf(50l));
      jmsTemplate.convertAndSend(paymentNotification);
      return new ModelAndView("dummy", "invoice", invoice);
   }
}
