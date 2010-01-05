package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.math.BigDecimal;

public class PaymentNotification
{

   String accountNumber;

   BigDecimal amount;

   public String getAccountNumber()
   {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber)
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
}
