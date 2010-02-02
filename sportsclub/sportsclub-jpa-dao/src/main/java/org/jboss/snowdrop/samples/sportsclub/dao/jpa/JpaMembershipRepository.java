package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Membership;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.MembershipRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaMembershipRepository extends JpaRepository<Membership, String> implements MembershipRepository
{

   public JpaMembershipRepository()
   {
      super(Membership.class);
   }

   public List<Membership> findAllActiveMembershipTypes()
   {
      Query query = entityManager.createQuery("FROM " + Membership.class.getSimpleName() + " m WHERE m.active = :active");
      query.setParameter("active", true);
      return query.getResultList();
   }

   public long countAll()
   {
      Query query = entityManager.createQuery("SELECT COUNT(code) FROM " + Membership.class.getSimpleName());
      return (Long) query.getSingleResult();
   }

   public List<String> findAllMembershipCodes()
   {
      Query query = entityManager.createQuery("SELECT m.code FROM " + Membership.class.getSimpleName() + " m WHERE m.active = :active");
      query.setParameter("active", true);
      return query.getResultList();
   }
}

