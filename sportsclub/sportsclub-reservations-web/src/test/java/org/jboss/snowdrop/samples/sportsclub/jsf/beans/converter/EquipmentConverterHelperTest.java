package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml", "classpath:dao-context.xml", "classpath:spring-converterHelpers.xml"})
public class EquipmentConverterHelperTest extends AbstractTestNGSpringContextTests
{

   @Autowired
   EquipmentConverterHelper equipmentConverterHelper;

   public EquipmentConverterHelperTest()
   {
      super();
   }

   @Test
   @Transactional
   public void testConversion()
   {
      // test that Spring wired EquipmentConverterHelper
      Assert.assertNotNull(equipmentConverterHelper);

      Equipment e = equipmentConverterHelper.getAsEquipment("1 Dummy");
   }

}
