package org.jboss.snowdrop.samples.sportsclub.dao.jpa;

import org.jboss.snowdrop.samples.sportsclub.domain.entity.Reservation;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.ReservationRepository;
import org.jboss.snowdrop.samples.sportsclub.domain.repository.criteria.ReservationSearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @author Marius Bogoevici
 */
@Repository
public class JpaReservationRepository extends JpaRepository<Reservation, Long> implements ReservationRepository {

    public JpaReservationRepository() {
        super(Reservation.class);
    }

    public Integer countByCriteria(ReservationSearchCriteria criteria) {
        return 0;
    }

    public List<Reservation> getByCriteria(ReservationSearchCriteria criteria) {
        return Collections.emptyList();
    }
}

