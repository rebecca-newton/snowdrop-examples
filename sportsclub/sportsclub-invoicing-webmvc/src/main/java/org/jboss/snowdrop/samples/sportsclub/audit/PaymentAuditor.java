package org.jboss.snowdrop.samples.sportsclub.audit;

import java.math.BigDecimal;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author Marius Bogoevici
 */
@ManagedResource(objectName = "sportsclub:name=paymentAuditor", description = "Payment Auditor", logFile = "log-sportsclub-auditor-jmx.log")
@Component
public class PaymentAuditor
{
   private boolean enabled = true;

   @ManagedAttribute
   public void setEnabled(boolean enabled)
   {
      this.enabled = enabled;
   }

   @ManagedAttribute
   public boolean getEnabled()
   {
      return this.enabled;
   }

   public void auditPayment(Long accountId, BigDecimal amount)
   {
      if (this.enabled)
      {
         System.out.println("AUDIT ENABLED! A payment has been made to account " + accountId + " for the amount of " + amount);
      }
      else
      { 
    	  System.out.println("AUDIT DISABLED!");   	  
      }
   }
}
