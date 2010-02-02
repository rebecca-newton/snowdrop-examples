package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Membership;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.MembershipRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaMembershipRepository extends JpaRepository<Membership,String> implements MembershipRepository {

    public JpaMembershipRepository() {
        super(Membership.class);
    }

    public List<Membership> findAllActiveMembershipTypes() {
        return Collections.emptyList();
    }

    public List<String> findAllMembershipCodes() {
        return Collections.emptyList();
    }
}

