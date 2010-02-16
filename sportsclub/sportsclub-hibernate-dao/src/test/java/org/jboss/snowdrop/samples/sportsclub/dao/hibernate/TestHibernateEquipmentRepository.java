package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.EquipmentRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.RangeCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;

import java.util.Collection;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
      "classpath:test-hibernate-infrastructure.xml",
      "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestHibernateEquipmentRepository
{
   @Autowired
   EquipmentRepository equipmentRepository;

   @Test
   public void testEquipmentTypes()
   {
      EquipmentType[] types = equipmentRepository.getEquipmentTypes();
      Assert.assertEquals(3,types.length);
   }

   @Test
   public void testRangeCriteria()
   {
      RangeCriteria criteria = new RangeCriteria();
      criteria.setRange(new Range(1,3));
      Collection<Equipment> equipments =  equipmentRepository.findByCriteria(criteria);
      Assert.assertEquals(3, equipments.size());
   }
}
