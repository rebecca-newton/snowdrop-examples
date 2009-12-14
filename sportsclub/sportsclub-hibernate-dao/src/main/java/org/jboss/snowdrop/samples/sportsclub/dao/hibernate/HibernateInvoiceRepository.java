package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;

public class HibernateInvoiceRepository extends HibernateRepository<Invoice, Long> implements InvoiceRepository
{
   public HibernateInvoiceRepository()
   {
      super(Invoice.class);
   }
   
}

