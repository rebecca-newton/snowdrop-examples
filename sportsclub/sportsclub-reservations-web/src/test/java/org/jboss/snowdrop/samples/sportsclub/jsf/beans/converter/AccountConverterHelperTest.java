package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.jboss.snowdrop.samples.sportsclub.service.AccountService;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml", "classpath:dao-context.xml", "classpath:spring-converterHelpers.xml"})
public class AccountConverterHelperTest extends AbstractTestNGSpringContextTests
{
   @Autowired
   AccountConverterHelper accountConverterHelper;

   @Autowired
   AccountService accountService;

   @Test
   public void testSpringAutowired()
   {
      Assert.assertNotNull(accountConverterHelper);
      Assert.assertNotNull(accountService);
   }

   @Test
   public void testConversionBackAndForth()
   {
      // assuming we have Account with id = 1
      Account a1 = accountService.getAccountById(1);

      Assert.assertNotNull(a1);

      String item = accountConverterHelper.getAsString(a1);
      Account a2 = accountConverterHelper.getAsAccount(item);

      Assert.assertNotNull(a2);
      Assert.assertEquals(a1.getId(), a2.getId());
      
   }
   
}
