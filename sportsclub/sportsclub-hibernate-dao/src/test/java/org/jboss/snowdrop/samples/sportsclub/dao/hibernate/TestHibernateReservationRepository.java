package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.ReservationRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.Range;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@ContextConfiguration(locations = {"classpath:test-db-infrastructure.xml",
      "classpath:test-hibernate-infrastructure.xml",
      "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestHibernateReservationRepository
{
   @Autowired
   ReservationRepository reservationRepository;

   @Test
   public void testFromToFilterCriteria()
   {
      Date from = getDate(2009, 1, 1);
      Date to = getDate(2009, 12, 31);

      ReservationSearchCriteria criteria = new ReservationSearchCriteria();
      criteria.setFromDate(from);
      criteria.setToDate(to);

      Assert.assertEquals(6, reservationRepository.getByCriteria(criteria).size());
      Assert.assertEquals(6, reservationRepository.countByCriteria(criteria).longValue());

      criteria = new ReservationSearchCriteria();
      criteria.setFromDate(getDate(2009, 02, 01));

      Assert.assertEquals(5, reservationRepository.getByCriteria(criteria).size());
      Assert.assertEquals(5, reservationRepository.countByCriteria(criteria).longValue());

      criteria = new ReservationSearchCriteria();
      criteria.setToDate(getDate(2009, 11, 30));

      Assert.assertEquals(5, reservationRepository.getByCriteria(criteria).size());
      Assert.assertEquals(5, reservationRepository.countByCriteria(criteria).longValue());
   }

   @Test
   public void testEquipmentTypeFilterCriteria()
   {
      Date from = getDate(2009, 1, 1);
      Date to = getDate(2009, 12, 31);

      List<EquipmentType> types = new ArrayList<EquipmentType>();
      types.add(EquipmentType.COURT);
      ReservationSearchCriteria criteria = new ReservationSearchCriteria();
      criteria.setFromDate(from);
      criteria.setToDate(to);
      criteria.setEquipmentType(types);

      Assert.assertEquals(1, reservationRepository.getByCriteria(criteria).size());
      Assert.assertEquals(1, reservationRepository.countByCriteria(criteria).longValue());
   }

   @Test
   public void testRangeCriteria()
   {
      ReservationSearchCriteria criteria = new ReservationSearchCriteria();
      criteria.setRange(new Range(1,3));
      List<Reservation> accountList = reservationRepository.getByCriteria(criteria);
      Assert.assertEquals(3, accountList.size());
   }

   private Date getDate(int year, int month, int day)
   {
      Calendar cal = Calendar.getInstance(Locale.US);
      cal.clear();
      cal.set(year, month - 1, day);
      return cal.getTime();
   }
}
