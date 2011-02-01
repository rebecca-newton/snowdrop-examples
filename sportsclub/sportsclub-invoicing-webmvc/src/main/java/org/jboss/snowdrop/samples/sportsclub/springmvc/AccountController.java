package org.jboss.snowdrop.samples.sportsclub.springmvc;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Payment;
import org.jboss.snowdrop.samples.sportsclub.ejb.SubscriptionService;
import org.jboss.spring.samples.sportsclub.invoicing.services.BillingService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ejb.EJB;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@Controller
public class AccountController
{

   private static final String[] invoiceStatus;

   static {
      invoiceStatus = new String[]{UserInput.INVOICE_WITHOUT, UserInput.INVOICE_WITH};
   }

   @EJB(mappedName = "sportsclub/BillingService")
   BillingService billingService;

   @EJB(mappedName = "sportsclub/SubscriptionService")
   SubscriptionService subscriptionService;

   /**
    * Just forwarding to the view with fresh-empty model.
    *
    * @param userInput
    * @return
    */
   @RequestMapping(value = "/searchAccount.do", method = RequestMethod.GET)
   ModelMap enterPage(UserInput userInput)
   {
      ModelMap model = new ModelMap();
      model.addAttribute(userInput)
           .addAttribute(invoiceStatus);
      return model;
   }

   @RequestMapping(value = "/searchAccount.do", method = RequestMethod.POST)
   ModelMap updateAccount(UserInput userInput)
   {
      String nameFragment = userInput.getNameFragment();
      Integer maxAccountNum = userInput.getMaxAccountNum();
      boolean withInvoice = (UserInput.INVOICE_WITH.equals(userInput.getInvoiceStatus()) ? true : false);

      List<Account> accountList = subscriptionService.findAccountsBySubscriberName(nameFragment, 0, maxAccountNum, withInvoice);

      ModelMap model = new ModelMap();
      model.addAttribute(userInput)
           .addAttribute(accountList)
           .addAttribute(invoiceStatus);
      return model;
   }

   @RequestMapping(value = "/accountDetail.do", method = RequestMethod.GET)
   ModelMap getAccountDetail(@RequestParam("id") String id)
   {
      Account account = subscriptionService.findAccountById(Long.parseLong(id));

      List<Invoice> invoices = billingService.getInvoices(account);

      boolean hasCurrentInvoice = false;
      Date currentDate = new Date();

      for (Invoice invoice: invoices)
      {
         if (invoice.getBillingPeriod().contains(currentDate))
         {
            hasCurrentInvoice = true;
            break;
         }
      }

      List<Payment> payments = billingService.getPayments(account);

      ModelMap model = new ModelMap();
      model.addAttribute(account);
      model.addAttribute("invoices", invoices);
      model.addAttribute("payments", payments);
      model.addAttribute("hasCurrentInvoice",hasCurrentInvoice);
      return model;
   }

   @RequestMapping(value = "/generateInvoice.do", method = RequestMethod.POST)
   @Secured("ROLE_ADMIN")
   ModelMap generateInvoice(@RequestParam("id") String id)
   {
      Account account = subscriptionService.findAccountById(Long.parseLong(id));
      Invoice invoice = billingService.generateInvoice(account);

      ModelMap model = new ModelMap();
      model.addAttribute("id",id);
      model.addAttribute(invoice);
      return model;
   }

}
