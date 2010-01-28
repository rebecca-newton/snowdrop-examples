package org.jboss.snowdrop.samples.sportsclub.springmvc;

/**
 * Represents option for HTML select list.
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class BooleanOption
{
   private String label;
   private boolean value;

   public BooleanOption(String label, boolean value)
   {
      this.label = label;
      this.value = value;
   }

   public String getLabel()
   {
      return label;
   }

   public void setLabel(String label)
   {
      this.label = label;
   }

   public boolean isValue()
   {
      return value;
   }

   public void setValue(boolean value)
   {
      this.value = value;
   }
}
