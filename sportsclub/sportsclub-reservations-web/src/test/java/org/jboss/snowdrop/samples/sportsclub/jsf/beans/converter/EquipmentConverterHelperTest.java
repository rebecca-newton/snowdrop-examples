package org.jboss.snowdrop.samples.sportsclub.jsf.beans.converter;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.service.EquipmentService;

/**
 * @author <a href="mailto:lvlcek@redhat.com">Lukas Vlcek</a>
 */
@ContextConfiguration(locations = {"classpath:test-infrastructure.xml", "classpath:dao-context.xml", "classpath:spring-converterHelpers.xml"})
public class EquipmentConverterHelperTest extends AbstractTestNGSpringContextTests
{

   @Autowired
   EquipmentConverterHelper equipmentConverterHelper;

   @Autowired
   EquipmentService equipmentService;

   public EquipmentConverterHelperTest()
   {
      super();
   }

   @Test
   public void testSpringAutowired()
   {
      Assert.assertNotNull(equipmentConverterHelper);
      Assert.assertNotNull(equipmentService);
   }

   @Test
   public void testConversionBackAndForth()
   {
      // assuming we have Equipment with id = 1
      Equipment e1 = equipmentService.findEquipmentById(1);

      Assert.assertNotNull(e1);

      String item = equipmentConverterHelper.getAsString(e1);
      Equipment e2 = equipmentConverterHelper.getAsEquipment(item);

      Assert.assertNotNull(e2);
      Assert.assertEquals(e1.getId(), e2.getId());

   }

}
