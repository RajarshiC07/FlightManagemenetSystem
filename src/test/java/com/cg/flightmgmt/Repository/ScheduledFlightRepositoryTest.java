package com.cg.flightmgmt.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.cg.flightmgmt.Entity.Flight;
import com.cg.flightmgmt.Entity.Schedule;
import com.cg.flightmgmt.Entity.ScheduledFlight;
@DataJpaTest
class ScheduledFlightRepositoryTest {

	ScheduledFlight scheduledFlight;

	@Autowired
	private ScheduledFlightDao scheduledflightDao;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {

		scheduledFlight = ScheduledFlight.builder().scheduledFlightId(346).availableSeats(10).flight(new Flight())
				.schedule(new Schedule()).build();
		entityManager.persist(scheduledFlight);
	}

	@Test
	void findById() {

		assertEquals(scheduledFlight, scheduledflightDao.findById(scheduledFlight.getScheduledFlightId()).get());
		
	}
	@Test
	void saving() {
		
		assertEquals(scheduledFlight, scheduledflightDao.save(scheduledFlight));
		
	}

	@Test
	void getlistofscheduledflight() {

		List<ScheduledFlight> l=scheduledflightDao.findAll();
		Assertions.assertThat(l.size()).isGreaterThanOrEqualTo(0);
		
	}
}
