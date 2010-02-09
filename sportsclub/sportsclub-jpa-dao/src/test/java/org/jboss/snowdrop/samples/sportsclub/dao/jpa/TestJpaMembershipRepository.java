package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.MembershipRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Membership;

import java.util.List;
import java.util.Arrays;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
                                   "classpath:TEST-jpa-infrastructure.xml",
                                   "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJpaMembershipRepository
{
   @Autowired
   MembershipRepository membershipRepository;

   @Test
   public void testCountAll()
   {
      long cnt = membershipRepository.countAll();
      Assert.assertEquals(3, cnt);
   }

   @Test
   public void testFindAllMembershipCodes()
   {
      List<String> codes = membershipRepository.findAllMembershipCodes();
      Assert.assertEquals(3, codes.size());
      Assert.assertTrue(codes.containsAll(Arrays.asList(new String[]{"GOLD","PLATINUM","SILVER"})));
   }

   @Test
   public void testFindAllActiveMembershipTypes()
   {
      List<Membership> memlist = membershipRepository.findAllActiveMembershipTypes();
      Assert.assertEquals(3, memlist.size());
   }
}
