package org.jboss.snowdrop.samples.sportsclub.domain.repository;

import java.util.List;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.InvoiceSearchCriteria;

public interface InvoiceRepository extends Repository<Invoice, Long>
{

   List<Invoice> findForAccount(Account account);

}
