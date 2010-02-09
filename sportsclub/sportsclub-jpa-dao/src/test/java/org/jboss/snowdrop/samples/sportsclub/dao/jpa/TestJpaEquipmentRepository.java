package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
                                   "classpath:TEST-jpa-infrastructure.xml",
                                   "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJpaEquipmentRepository
{
   @Autowired
   EquipmentRepository equipmentRepository;

   @Test
   public void testEquipmentTypes()
   {
      EquipmentType[] types = equipmentRepository.getEquipmentTypes();
      Assert.assertEquals(3,types.length);
   }
}
