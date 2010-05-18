package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentNotification implements Serializable
{

   Long accountNumber;

   BigDecimal amount;

   public Long getAccountNumber()
   {
      return accountNumber;
   }

   public void setAccountNumber(Long accountNumber)
   {
      this.accountNumber = accountNumber;
   }

   public BigDecimal getAmount()
   {
      return amount;
   }

   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }

   @Override
   public String toString()
   {
      return "PaymentNotification[accountId=" + accountNumber + ", amount=" + amount + "]";
   }
}
