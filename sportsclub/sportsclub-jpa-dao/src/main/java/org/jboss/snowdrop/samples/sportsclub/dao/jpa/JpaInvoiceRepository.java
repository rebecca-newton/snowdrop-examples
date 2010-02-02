package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Invoice;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.InvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaInvoiceRepository extends JpaRepository<Invoice, Long> implements InvoiceRepository {

    public JpaInvoiceRepository() {
        super(Invoice.class);
    }

    public List<Invoice> findForAccount(Account account) {
        return Collections.emptyList(); //TODO create real implementation
    }
}
