package org.jboss.snowdrop.samples.sportsclub.springmvc;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class UserInput
{
   private boolean currentInvoice;
   private String data;
   private String firstName;
   private String lastName;

   public String getData()
   {
      return data;
   }

   public void setData(String data)
   {
      this.data = data;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public boolean isCurrentInvoice()
   {
      return currentInvoice;
   }

   public void setCurrentInvoice(boolean currentInvoice)
   {
      this.currentInvoice = currentInvoice;
   }
}
