package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Balance
{
   @Id   
   @GeneratedValue(generator = "foreign")
   @GenericGenerator(
         name = "foreign", strategy = "foreign", parameters = {@Parameter(name = "property", value = "account")}
   )
   private Long id;

   @OneToOne(mappedBy = "balance")
   private Account account;

   private BigDecimal currentBalance;


   public Long getId()
   {
      return id;
   }

   public Account getAccount()
   {
      return account;
   }

   public void setAccount(Account account)
   {
      this.account = account;
   }

   public BigDecimal getCurrentBalance()
   {
      return currentBalance;
   }

   public void setCurrentBalance(BigDecimal currentBalance)
   {
      this.currentBalance = currentBalance;
   }

   public void credit(BigDecimal amount)
   {
      this.currentBalance.subtract(amount);
   }

   public void debit(BigDecimal amount)
   {
      this.currentBalance.add(amount);
   }
}
