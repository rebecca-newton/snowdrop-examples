package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.BillingType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaAccountRepository extends JpaRepository<Account, Long> implements AccountRepository {

    public JpaAccountRepository() {
        super(Account.class);
    }

    public int countByCriteria(AccountSearchCriteria accountSearchCriteria) {
        return this.findAll().size(); // TODO create real implementation
    }

    public List<Account> findByPersonName(String name) {
        // TODO create real implementation
        return this.findAll();
    }

    public List<Account> findByCriteria(AccountSearchCriteria accountSearchCriteria) {
        // TODO create real implementation
        if (accountSearchCriteria.getRange() != null)
            return this.findAll().subList(accountSearchCriteria.getRange().getMinIndex(), accountSearchCriteria.getRange().getMaxIndex());
        else
            return this.findAll();
    }
}
