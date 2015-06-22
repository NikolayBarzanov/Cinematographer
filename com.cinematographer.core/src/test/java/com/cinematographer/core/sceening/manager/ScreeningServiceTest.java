package com.cinematographer.core.sceening.manager;

import static com.cinematographer.core.screening.Status.FREE;
import static com.cinematographer.core.screening.Status.RESERVED;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Time;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.cinematographer.core.DatabaseTest;
import com.cinematographer.core.screening.Screening;
import com.cinematographer.core.screening.Seat;
import com.cinematographer.core.screening.manager.ScreeningService;

public class ScreeningServiceTest extends DatabaseTest {

	private static final String TEST_TITLE = "Title";

	private static final Time TEST_DURATION = new Time(1000 * 60 * 120);
	private static final int TEST_HALL = 11;
        private static final double TEST_PRISE = 10;
	private static final Time TEST_START_TIME = new Time(12341204812L);
	private static final Seat TEST_SEATS[] = { new Seat("0", false, FREE),
			new Seat("1", false, FREE), new Seat("2", true, RESERVED),
			new Seat("3", true, RESERVED) };
	private static final Screening TEST_SCREENING = new Screening(TEST_TITLE,
			TEST_START_TIME, TEST_DURATION, Arrays.asList(TEST_SEATS),
			TEST_HALL,TEST_PRISE);

	private ScreeningService classUnderTest;

	@Before
	public void setUp() {
		super.setUp();
		createDatabaseElements();
		classUnderTest = new ScreeningService(emf);
	}

	private void createDatabaseElements() {
		addScreening(TEST_SCREENING);
	}

	private void addScreening(Screening screening) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(screening);
		transaction.commit();
	}

	@Test
	public void findScreeningTest() {
		assertThat(classUnderTest.findScreening(TEST_TITLE), is(TEST_SCREENING));
		assertThat(classUnderTest.findScreening("random title"), nullValue());
	} 

	@Test
	public void getAllScreeningsTest() {
		assertThat(classUnderTest.getAllScreenings(),
				Matchers.contains(TEST_SCREENING));
	}

	@Test
	public void createScreeningTest() {
		Screening screening = new Screening();
		screening.setTitle("Title!");
		classUnderTest.addScreening(screening);

		assertThat(classUnderTest.getAllScreenings(),
				Matchers.containsInAnyOrder(TEST_SCREENING, screening));
	}

	@Test
	public void removeScreeningTest() {
		classUnderTest.removeScreening(TEST_TITLE);
		assertThat(classUnderTest.findScreening(TEST_TITLE), nullValue());
		assertThat(classUnderTest.getAllScreenings(), empty());
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
