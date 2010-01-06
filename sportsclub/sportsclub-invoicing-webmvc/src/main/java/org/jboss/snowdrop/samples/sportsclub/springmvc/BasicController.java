package org.jboss.snowdrop.samples.sportsclub.springmvc;

import javax.ejb.EJB;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.ejb.SubscriptionService;
import org.jboss.spring.samples.sportsclub.invoicing.services.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController
{
  @EJB(mappedName = "sportsclub-ear-1.0-SNAPSHOT/BillingServiceImpl/local")
  BillingService billingService;


  @EJB(mappedName = "sportsclub-ear-1.0-SNAPSHOT/SubscriptionServiceImpl/local")
  SubscriptionService subscriptionService;


  @RequestMapping("/basic.do")
  ModelAndView doSomething()
  {
     Account account = subscriptionService.findAccountsBySubscriberName("Vimes", 0, 1).get(0);
     Invoice invoice = billingService.generateInvoice(account);
     return new ModelAndView("dummy", "invoice", invoice);
  }
}
