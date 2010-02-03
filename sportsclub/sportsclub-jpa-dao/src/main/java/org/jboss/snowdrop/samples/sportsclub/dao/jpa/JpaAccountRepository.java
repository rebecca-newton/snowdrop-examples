package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.BillingType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.AccountRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.AccountSearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaAccountRepository extends JpaRepository<Account, Long> implements AccountRepository
{

   public JpaAccountRepository()
   {
      super(Account.class);
   }

//   public List<Account> findByPersonName(String name)
//   {
//      Query query = entityManager.createQuery(" from " + Account.class.getSimpleName() + " a " +
//            "where a.subscriber.name.firstName like :name " +
//            "or a.subscriber.name.lastName like :name " +
//            "or a.subscriber.name.middleName like :name");
//      query.setParameter("name", "%" + name + "%");
//      return query.getResultList();
//   }

   public int countByCriteria(AccountSearchCriteria accountSearchCriteria)
   {
      return this.findAll().size(); // TODO create real implementation
   }

   public List<Account> findByCriteria(AccountSearchCriteria accountSearchCriteria)
   {
      // TODO create real implementation
      if (accountSearchCriteria.getRange() != null)
         return this.findAll().subList(accountSearchCriteria.getRange().getMinIndex(), accountSearchCriteria.getRange().getMaxIndex());
      else
         return this.findAll();
   }
}
