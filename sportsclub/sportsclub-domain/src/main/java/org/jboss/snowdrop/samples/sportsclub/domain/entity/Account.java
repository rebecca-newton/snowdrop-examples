package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;

import javax.persistence.*;
import java.util.Date;

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


}

