package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment
{
   @Id
   Long id;

   private BigDecimal amount;

   @ManyToOne
   private Account account;

   private Date date;

   public Long getId()
   {
      return id;
   }

   public BigDecimal getAmount()
   {
      return amount;
   }

   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }

   public Account getAccount()
   {
      return account;
   }

   public void setAccount(Account account)
   {
      this.account = account;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }
}
