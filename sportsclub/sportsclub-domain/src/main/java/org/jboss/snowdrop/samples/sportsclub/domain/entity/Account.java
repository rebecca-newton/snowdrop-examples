package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
@Entity
public class Account
{
   @Id
   @GeneratedValue
   private Long id;

   @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
   private Person subscriber;

   @Embedded
   private Balance balance;

   private Date creationDate;

   @ManyToOne
   private Membership membership;

   private BillingType billingType;

   private boolean closed;

   private Date closeDate;

   
   public Account()
   {
      this.balance = new Balance();
      this.balance.setAmount(BigDecimal.ZERO);
   }

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
      return membership.getAnnualFee().divide(BigDecimal.valueOf(billingType.periodsPerYear()), 2, RoundingMode.CEILING);
   }

   public Balance getBalance()
   {
      return balance;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (o == null || getClass() != o.getClass())
      {
         return false;
      }

      Account that = (Account) o;

      if (id != null ? !id.equals(that.id) : that.id != null)
      {
         return false;
      }

      return true;
   }

   @Override
   public int hashCode()
   {
      return id != null ? id.hashCode() : 0;
   }
}

