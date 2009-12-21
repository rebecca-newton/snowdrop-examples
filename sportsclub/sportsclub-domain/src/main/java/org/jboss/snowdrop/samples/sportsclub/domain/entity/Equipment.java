package org.jboss.snowdrop.samples.sportsclub.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */

@Entity
public class Equipment
{
   @Id
   @GeneratedValue
   private Long id;

   private String name;

   private String description;

   @Column(name = "eqp_type_id", nullable = false, updatable = false)
   private EquipmentType equipmentType;


   public long getId()
   {
      return id;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public EquipmentType getEquipmentType()
   {
      return equipmentType;
   }

   public void setEquipmentType(EquipmentType equipmentType)
   {
      this.equipmentType = equipmentType;
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

      Equipment that = (Equipment) o;

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
