package org.jboss.snowdrop.samples.sportsclub.springmvc;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
public class UserInput
{
   private static final int DEFAULT_MAX_ACCOUNT_NUM = 20;
   static final String INVOICE_WITH = "with";
   static final String INVOICE_WITHOUT = "without";

   private String invoiceStatus;
   private Integer maxAccountNum = DEFAULT_MAX_ACCOUNT_NUM;
   private String nameFragment;

   public String getNameFragment()
   {
      return nameFragment;
   }

   /**
    * @param nameFragment if not null then it is always trimmed
    */
   public void setNameFragment(String nameFragment)
   {
      if (nameFragment != null)
      {
         nameFragment = nameFragment.trim();
      }
      this.nameFragment = nameFragment;
   }

   public Integer getMaxAccountNum()
   {
      return maxAccountNum;
   }

   /**
    * @param maxAccountNum if null then the value is set to DEFAULT_MAX_ACCOUNT_NUM
    */
   public void setMaxAccountNum(Integer maxAccountNum)
   {
      if (maxAccountNum == null)
         this.maxAccountNum = DEFAULT_MAX_ACCOUNT_NUM;
      else
         this.maxAccountNum = maxAccountNum;
   }

   public String getInvoiceStatus()
   {
      return invoiceStatus;
   }

   public void setInvoiceStatus(String invoiceStatus)
   {
      this.invoiceStatus = invoiceStatus;
   }
}
