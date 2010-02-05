package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
@Entity
public class Invoice
{

   @Id @GeneratedValue
   private Long id;

   @ManyToOne
   private Account account;

   private Date issueDate;

   private TimeInterval billingPeriod;

   private BigDecimal amount;

   public long getId()
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

   public BigDecimal getAmount()
   {
      return amount;
   }

   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }

   public Date getIssueDate()
   {
      return issueDate;
   }

   public void setIssueDate(Date issueDate)
   {
      this.issueDate = issueDate;
   }

   public TimeInterval getBillingPeriod()
   {
      return billingPeriod;
   }

   public void setBillingPeriod(TimeInterval billingPeriod)
   {
      this.billingPeriod = billingPeriod;
   }
}

