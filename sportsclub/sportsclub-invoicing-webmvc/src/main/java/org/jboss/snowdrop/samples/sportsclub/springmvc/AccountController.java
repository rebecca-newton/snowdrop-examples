package org.jboss.snowdrop.samples.sportsclub.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@Controller
public class AccountController
{

   @RequestMapping(value = "/searchAccount.do", method = RequestMethod.GET)
   ModelMap enterPage(UserInput userInput)
   {
      userInput.setData("get");

      ModelMap model = new ModelMap();
      model.addAttribute(userInput);
      return model;
   }

   @RequestMapping(value = "/searchAccount.do", method = RequestMethod.POST)
   ModelMap updateAccount(UserInput userInput)
   {

      userInput.setData("post");

      ModelMap model = new ModelMap();
      model.addAttribute(userInput);
      return model;
   }

}
