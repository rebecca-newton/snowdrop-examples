package org.jboss.snowdrop.samples.sportsclub.dao.jpa.initializer;

import static org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType.COURT;
import static org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType.STEPPER;
import static org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType.TREADMILL;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Account;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Address;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.BillingType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Equipment;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.EquipmentType;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Membership;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Name;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Person;
import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;

/**
 * @author <a href="mailto:mariusb@redhat.com">Marius Bogoevici</a>
 */
public class DatabaseInitializer implements InitializingBean
{

   @Autowired
   private EntityManager entityManager;

   @Autowired
   private PlatformTransactionManager transactionManager;

   public void afterPropertiesSet() throws Exception
   {
      new TransactionTemplate(transactionManager).execute(new TransactionCallback()
      {
         public Object doInTransaction(TransactionStatus status)
         {

            Query query = DatabaseInitializer.this.entityManager.createQuery("select count(m) from Membership m");

            if (((Long) query.getSingleResult()) > 0)
            {
               return null;
            }

            Membership silverMembership = createMembership("SILVER", "600.0");
            Membership goldMembership = createMembership("GOLD", "900.0");
            Membership platinumMembership = createMembership("PLATINUM", "1200.0");

            save(DatabaseInitializer.this.entityManager, silverMembership);
            save(DatabaseInitializer.this.entityManager, goldMembership);
            save(DatabaseInitializer.this.entityManager, platinumMembership);


            Map<String, Person> persons = new HashMap<String, Person>();

            persons.put("person1", createPerson("Samuel", "Vimes", "1 Yonge", "Toronto", "Ontario", "Canada"));
            persons.put("person2", createPerson("Sibyl", "Vimes", "1 Yonge", "Toronto", "Ontario", "Canada"));
            persons.put("person3", createPerson("Havelock", "Vetinari", "1 Bloor", "Toronto", "Ontario", "Canada"));
            persons.put("person4", createPerson("Nobby", "Nobbs", "1 Dufferin", "Toronto", "Ontario", "Canada"));
            persons.put("person5", createPerson("Carrot", "Ironfoundersson", "1 King", "Toronto", "Ontario", "Canada"));
            persons.put("person6", createPerson("Magrat", "Garlick", "1 King", "Lancre", "Ramtops", "Canada"));
            persons.put("person7", createPerson("Gytha", "Ogg", "1 King", "Lancre", "Ramtops", "Canada"));
            persons.put("person8", createPerson("Esmerelda", "Weatherwax", "1 King", "Lancre", "Ramtops", "Canada"));
            persons.put("person9", createPerson("Mustrum", "Ridcully", "1 King", "Lancre", "Ramtops", "Canada"));
            persons.put("person10", createPerson("Bill", "Door", "1 King", "Lancre", "Ramtops", "Canada"));
            persons.put("person11", createPerson("Angua", "von Uberwald", "1 King", "Lancre", "Ramtops", "Canada"));
            persons.put("person12", createPerson("Claude", "Dibbler", "1 King", "Lancre", "Ramtops", "Canada"));

            saveMap(DatabaseInitializer.this.entityManager, persons);


            Map<String, Account> accounts = new HashMap<String, Account>();

            accounts.put("account1", createAccount(silverMembership, BillingType.MONTHLY, persons.get("person1")));
            accounts.put("account2", createAccount(goldMembership, BillingType.WEEKLY, persons.get("person2")));
            accounts.put("account3", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person3")));
            accounts.put("account4", createAccount(goldMembership, BillingType.BIWEEKLY, persons.get("person4")));
            accounts.put("account5", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person5")));
            accounts.put("account6", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person6")));
            accounts.put("account7", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person7")));
            accounts.put("account8", createAccount(platinumMembership, BillingType.MONTHLY, persons.get("person8")));
            accounts.put("account9", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person9")));
            accounts.put("account10", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person10")));
            accounts.put("account11", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person11")));
            accounts.put("account12", createAccount(platinumMembership, BillingType.BIWEEKLY, persons.get("person12")));

            saveMap(DatabaseInitializer.this.entityManager, accounts);


            Map<String, Equipment> equipments = new HashMap<String, Equipment>();

            equipments.put("equipment1", createEquipment("Engage", "95T Engage by LifeFitness", TREADMILL));
            equipments.put("equipment2", createEquipment("Inclusive", "95T Inclusive by LifeFitness", TREADMILL));
            equipments.put("equipment3", createEquipment("Omnidirectional", "by Cyberwalk", TREADMILL));
            equipments.put("equipment4", createEquipment("Squash", "by Court Company", COURT));
            equipments.put("equipment5", createEquipment("FreeMotion", "FreeMotion s5.6 by NordicTrack", STEPPER));
            equipments.put("equipment6", createEquipment("MTN", "MTN 740 by NordicTrack", STEPPER));

            saveMap(DatabaseInitializer.this.entityManager, equipments);


            Map<String, Reservation> reservations = new HashMap<String, Reservation>();

            reservations.put("reservation1", createReservation(createDate(2009, 02, 01), createDate(2009, 10, 31), equipments.get("equipment1"), accounts.get("account1")));
            reservations.put("reservation2", createReservation(createDate(2009, 01, 01), createDate(2009, 12, 31), equipments.get("equipment2"), accounts.get("account2")));
            reservations.put("reservation3", createReservation(createDate(2009, 05, 01), createDate(2009, 10, 31), equipments.get("equipment3"), accounts.get("account3")));
            reservations.put("reservation4", createReservation(createDate(2009, 07, 01), createDate(2009, 07, 02), equipments.get("equipment4"), accounts.get("account4")));
            reservations.put("reservation5", createReservation(createDate(2009, 07, 01), createDate(2009, 07, 02), equipments.get("equipment5"), accounts.get("account5")));
            reservations.put("reservation6", createReservation(createDate(2009, 07, 01), createDate(2009, 07, 02), equipments.get("equipment6"), accounts.get("account6")));

            saveMap(DatabaseInitializer.this.entityManager, reservations);

            return null;
         }
      });
   }

   private static void saveMap(EntityManager entityManager, Map data)
   {
      for (String key : (Set<String>)data.keySet())
      {
         save(entityManager, data.get(key));
      }
   }

   private static void save(EntityManager entityManager, Object entity)
   {
      entityManager.persist(entity);
      //entityManager.flush();
   }

   private static Account createAccount(Membership silverMembership, BillingType billingType, Person person)
   {
      Account account = new Account();
      account.setSubscriber(person);
      account.setCreationDate(new Date());
      account.setBillingType(billingType);
      account.setMembership(silverMembership);
      account.setClosed(false);
      return account;
   }

   private static Person createPerson(String firstname, String lastname, String street, String city, String province, String country)
   {
      Person person = new Person();
      person.setName(new Name());
      person.setAddress(new Address());

      person.getName().setFirstName(firstname);
      person.getName().setLastName(lastname);
      person.getAddress().setStreetAddress(street);
      person.getAddress().setCity(city);
      person.getAddress().setProvinceOrState(province);
      person.getAddress().setCountry(country);
      person.getAddress().setPostalCode("H0H0H0");
      return person;
   }

   private static Membership createMembership(String code, String amount)
   {
      Membership membership = new Membership(code);
      membership.setActive(true);
      membership.setAnnualFee(new BigDecimal(amount));
      return membership;
   }

   private static Equipment createEquipment(String name, String description, EquipmentType type)
   {
      Equipment equipment = new Equipment();
      equipment.setDescription(description);
      equipment.setName(name);
      equipment.setEquipmentType(type);
      return equipment;
   }

   private static Reservation createReservation(Date fromDate, Date toDate, Equipment equipment, Account account)
   {
      assert fromDate.before(toDate);
      Reservation reservation = new Reservation();
      reservation.setAccount(account);
      reservation.setEquipment(equipment);
      reservation.setFrom(fromDate);
      reservation.setTo(toDate);
      return reservation;
   }

   /**
    * Months are human readable and start at 1!
    */
   private static Date createDate(int year, int month, int day)
   {
      Calendar cal = Calendar.getInstance(Locale.US);
      cal.clear();
      cal.set(year, month - 1, day);
      return cal.getTime();
   }
}