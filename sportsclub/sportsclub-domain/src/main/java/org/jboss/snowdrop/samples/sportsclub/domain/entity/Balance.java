package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Balance
{

   private BigDecimal amount;

   public BigDecimal getAmount()
   {
      return amount;
   }

   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }

   public void credit(BigDecimal amount)
   {
      this.amount = this.amount.subtract(amount);
   }

   public void debit(BigDecimal amount)
   {
      this.amount = this.amount.add(amount);
   }
}
