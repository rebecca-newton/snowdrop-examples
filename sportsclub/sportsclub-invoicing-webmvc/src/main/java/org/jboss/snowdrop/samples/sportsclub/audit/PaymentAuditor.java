package org.jboss.snowdrop.samples.sportsclub.audit;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author Marius Bogoevici
 */
@ManagedResource(objectName = "sportsclub:name=paymentAuditor", description = "Payment Auditor")
@Component
public class PaymentAuditor
{

   private static final Log LOG = LogFactory.getLog(PaymentAuditor.class);

   private boolean enabled = true;

   @ManagedAttribute(description = "Audit enabled")
   public void setEnabled(boolean enabled)
   {
      LOG.info("Audit " +  (enabled ? "enabled":"disabled"));
      this.enabled = enabled;
   }

   @ManagedAttribute(description = "Audit enabled")
   public boolean getEnabled()
   {
      return this.enabled;
   }

   public void auditPayment(Long accountId, BigDecimal amount)
   {
      if (this.enabled)
      {
         LOG.info("A payment has been made to account " + accountId + " for the amount of " + amount);
      }
   }
}
