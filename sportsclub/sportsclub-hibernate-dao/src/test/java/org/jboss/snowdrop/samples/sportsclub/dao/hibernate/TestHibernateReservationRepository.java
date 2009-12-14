package org.jboss.snowdrop.samples.sportsclub.dao.hibernate;

import org.jboss.snowdrop.samples.sportsclub.domain.repository.ReservationRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

@ContextConfiguration(locations = {"classpath:test-infrastructure.xml", "classpath:dao-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestHibernateReservationRepository
{
   @Autowired
   ReservationRepository reservationRepository;

   @Test
   @Transactional
   public void testFromToFilterCriteria()
   {

      Date from = getDate(2009, 1, 1);
      Date to = getDate(2009, 12, 31);

      ReservationSearchCriteria criteria = new ReservationSearchCriteria();
      criteria.setFromDate(from);
      criteria.setToDate(to);

      List<Reservation> reservations = reservationRepository.getByCriteria(criteria);
      Assert.assertEquals(6, reservations.size());

      criteria = new ReservationSearchCriteria();
      criteria.setFromDate(getDate(2009, 02, 01));

      reservations = reservationRepository.getByCriteria(criteria);
      Assert.assertEquals(5, reservations.size());

      criteria = new ReservationSearchCriteria();
      criteria.setToDate(getDate(2009, 11, 30));

      reservations = reservationRepository.getByCriteria(criteria);
      Assert.assertEquals(5, reservations.size());
   }

   @Test
   @Transactional
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

      List<Reservation> reservations = reservationRepository.getByCriteria(criteria);

      Assert.assertEquals(1, reservations.size());
   }

   private Date getDate(int year, int month, int day)
   {
      Calendar cal = Calendar.getInstance(Locale.US);
      cal.clear();
      cal.set(year, month - 1, day);
      return cal.getTime();
   }
}
