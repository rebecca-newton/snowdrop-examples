package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
@Entity
public class Account
{
   @Id @GeneratedValue
   private Long id;

   @OneToOne(cascade = {CascadeType.ALL})
   private Person subscriber;

   @OneToOne(cascade = {CascadeType.ALL})
   @PrimaryKeyJoinColumn
   private Balance balance;

   private Date creationDate;

   @ManyToOne
   private Membership membership;

   private BillingType billingType;

   private boolean closed;

   private Date closeDate;

   public long getId()
   {
      return id;
   }

   public Person getSubscriber()
   {
      return subscriber;
   }

   public void setSubscriber(Person subscriber)
   {
      this.subscriber = subscriber;
      subscriber.setAccount(this);
   }

   public BillingType getBillingType()
   {
      return billingType;
   }

   public void setBillingType(BillingType billingType)
   {
      this.billingType = billingType;
   }

   public Date getCreationDate()
   {
      return creationDate;
   }

   public void setCreationDate(Date creationDate)
   {
      this.creationDate = creationDate;
   }

   public Membership getMembership()
   {
      return membership;
   }

   public void setMembership(Membership membership)
   {
      this.membership = membership;
   }

   public boolean isClosed()
   {
      return closed;
   }

   public void setClosed(boolean closed)
   {
      this.closed = closed;
   }

   public Date getCloseDate()
   {
      return closeDate;
   }

   public void setCloseDate(Date closeDate)
   {
      this.closeDate = closeDate;
   }

   public BigDecimal getFeePerBillingPeriod()
   {
      return membership.getAnnualFee().divide(BigDecimal.valueOf(billingType.periodsPerYear()));
   }

   public Balance getBalance()
   {
      return balance;
   }

   public void resetBalance()
   {
      this.balance = new Balance();
      this.balance.setAccount(this);
      this.balance.setCurrentBalance(BigDecimal.ZERO);
   }
}

