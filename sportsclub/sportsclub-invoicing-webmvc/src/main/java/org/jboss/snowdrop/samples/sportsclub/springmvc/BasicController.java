package org.jboss.snowdrop.samples.sportsclub.springmvc;

import javax.ejb.EJB;

import org.jboss.spring.samples.sportsclub.invoicing.services.BillingService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: marius
 * Date: 5-Jan-2010
 * Time: 3:27:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/basic")
public class BasicController
{
  @EJB
  BillingService billingService;

  @RequestMapping
  String doSomething()
  {
     return "dummy";
  }
}
