package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */

@Entity
public class Reservation
{

   @Id @GeneratedValue
   private long id;

   @Column(name = "fromDT", nullable = false)
   private Date from;

   @Column(name = "toDT", nullable = false)
   private Date to;

   @ManyToOne
   private Equipment equipment;

   @ManyToOne
   private Account account;


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

   public Equipment getEquipment()
   {
      return equipment;
   }

   public void setEquipment(Equipment equipment)
   {
      this.equipment = equipment;
   }

   public Date getFrom()
   {
      return from;
   }

   public void setFrom(Date from)
   {
      this.from = from;
   }

   public Date getTo()
   {
      return to;
   }

   public void setTo(Date to)
   {
      this.to = to;
   }
}
