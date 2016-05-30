package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import asgn2Aircraft.*;
import asgn2Passengers.*;

/**
 * 
 * @author Bryce Rochecouste
 *
 */

public class AircraftTests {

	/**
	 * Test to ensure that the constructors of the subclasses implement variables properly
	 * 
	 * @throws AircraftException
	 */
	@Test
	public void ConstructorAircraftTest() throws AircraftException {
		A380 testFlight = new A380("SEA111", 1200);
		assertTrue(testFlight.flightEmpty());
		assertEquals(484, testFlight.getBookings().getAvailable());
	}
	
	/**
	 * Test to ensure that the constructors of the subclasses implement variables properly
	 * 
	 * @throws AircraftException
	 */
	@Test
	public void ConstructorAircraftTest2() throws AircraftException {
		B747 testFlight = new B747("SEA111", 1200);
		assertTrue(testFlight.flightEmpty());
		assertEquals(353, testFlight.getBookings().getAvailable());
	}
	
	/**
	 * Tests that bookings are confirmed and the hasPassenger function
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void confirmBookingTest() throws AircraftException, PassengerException {
		Economy pE = new Economy(1000,1200);
		Business pB = new Business(1000,1200);
		A380 testFlight = new A380("SEA111", 1200);
		testFlight.confirmBooking(pE, 1100);
		testFlight.confirmBooking(pB, 1100);
		assertEquals(1, testFlight.getNumEconomy());
		assertEquals(2, testFlight.getNumPassengers());
		assertTrue(testFlight.hasPassenger(pE));
	}
	
	/**
	 * Tests that bookings are cancelled after being confirmed
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void cancelBookingTest() throws AircraftException, PassengerException {
		Economy pE = new Economy(1000,1200);
		Business pB = new Business(500,1200);
		A380 testFlight = new A380("SEA111", 1200);
		testFlight.confirmBooking(pE, 1000);
		testFlight.confirmBooking(pB, 500);
		testFlight.cancelBooking(pB, 1000);
		assertEquals(0, testFlight.getNumBusiness());
		assertEquals(1, testFlight.getNumPassengers());
		assertTrue(!testFlight.hasPassenger(pB));
	}
	
	/**
	 * Tests multiple booking confirmations and cancellations
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void cancelAndConfirmTest() throws AircraftException, PassengerException {
		Economy pE = new Economy(900,1200);
		Economy pE2 = new Economy(1100,1200);
		Economy pE3 = new Economy(700,1200);
		Business pB = new Business(100,1200);
		Business pB2 = new Business(400,1200);
		Business pB3 = new Business(1100,1200);
		Premium pP = new Premium(500,1200);
		First pF = new First(1100,1200);
		A380 testFlight = new A380("SEA111", 1200);
		testFlight.confirmBooking(pE, 1100);
		testFlight.confirmBooking(pE2, 1100);
		testFlight.confirmBooking(pE3, 1100);
		testFlight.confirmBooking(pB, 1100);
		testFlight.confirmBooking(pB2, 1100);
		testFlight.confirmBooking(pB3, 1100);
		testFlight.confirmBooking(pP, 1100);
		testFlight.confirmBooking(pF, 1100);
		testFlight.cancelBooking(pE2, 1130);
		testFlight.cancelBooking(pB3, 1130);
		testFlight.cancelBooking(pP, 1130);
		assertEquals(2, testFlight.getNumEconomy());
		assertEquals(1, testFlight.getNumFirst());
		assertEquals(5, testFlight.getNumPassengers());
		assertTrue(!testFlight.hasPassenger(pP));
	}
	
	/**
	 * Tests the upgradeBookings function with cancellations and First class Passengers (not upgradable)
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void upgradeTest() throws AircraftException, PassengerException {
		Economy pE = new Economy(900,1200);
		Economy pE2 = new Economy(1100,1200);
		Economy pE3 = new Economy(700,1200);
		Business pB = new Business(100,1200);
		Business pB2 = new Business(400,1200);
		Business pB3 = new Business(1100,1200);
		Premium pP = new Premium(500,1200);
		First pF = new First(1100,1200);
		A380 testFlight = new A380("SEA111", 1200);
		testFlight.confirmBooking(pE, 1100);
		testFlight.confirmBooking(pE2, 1100);
		testFlight.confirmBooking(pE3, 1100);
		testFlight.confirmBooking(pB, 1100);
		testFlight.confirmBooking(pB2, 1100);
		testFlight.confirmBooking(pB3, 1100);
		testFlight.confirmBooking(pP, 1100);
		testFlight.confirmBooking(pF, 1100);
		testFlight.cancelBooking(pE2, 1130);
		testFlight.cancelBooking(pB3, 1130);
		testFlight.cancelBooking(pP, 1130);
		testFlight.upgradeBookings();
		assertEquals(2, testFlight.getNumPremium());
		assertEquals(3, testFlight.getNumFirst());
		assertEquals(5, testFlight.getNumPassengers());		
	}
	
	/**
	 * Tests seatsAvailable function in 2 situations
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void seatsAvailableTest() throws AircraftException, PassengerException {
		A380 testFlight = new A380("SEA122", 1300, 1, 2, 1, 4);
		First pF = new First(1100,1300);
		Business pB = new Business(100,1300);
		testFlight.confirmBooking(pF, 1200);
		testFlight.confirmBooking(pB, 1200);
		assertFalse(testFlight.seatsAvailable(pF));
		assertTrue(testFlight.seatsAvailable(pB));
	}
	
	/**
	 * A simple Test that confirms that the passengers have flown once the plane has left
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void flyPassengersTest() throws AircraftException, PassengerException {
		A380 testFlight = new A380("SEA122", 1300, 1, 2, 1, 4);
		First pF = new First(1100,1300);
		Business pB = new Business(100,1300);
		testFlight.confirmBooking(pF, 1200);
		testFlight.confirmBooking(pB, 1200);
		testFlight.flyPassengers(1300);
		assertTrue(pF.isFlown());
		assertTrue(pB.isFlown());
	}
	
	/**
	 * A simple Test for the flightFull function
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void flightFullTest() throws AircraftException, PassengerException {
		A380 testFlight = new A380("SEA122", 1300, 1, 1, 0, 0);
		First pF = new First(1100,1300);
		Business pB = new Business(100,1300);
		testFlight.confirmBooking(pF, 1200);
		testFlight.confirmBooking(pB, 1200);
		assertTrue(testFlight.flightFull());
	}
	
	/**
	 * Another upgrade test that ensures that when there are no more available places to upgrade that
	 * some do not get upgraded
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void upgradeTest2() throws AircraftException, PassengerException {
		Economy pE = new Economy(900,1200);
		Economy pE2 = new Economy(1100,1200);
		Economy pE3 = new Economy(700,1200);
		Business pB = new Business(100,1200);
		Business pB2 = new Business(400,1200);
		Business pB3 = new Business(1100,1200);
		Premium pP = new Premium(500,1200);
		First pF = new First(1100,1200);
		A380 testFlight = new A380("SEA111", 1200, 2, 10, 10, 40);
		testFlight.confirmBooking(pE, 1100);
		testFlight.confirmBooking(pE2, 1100);
		testFlight.confirmBooking(pE3, 1100);
		testFlight.confirmBooking(pB, 1100);
		testFlight.confirmBooking(pB2, 1100);
		testFlight.confirmBooking(pB3, 1100);
		testFlight.confirmBooking(pP, 1100);
		testFlight.confirmBooking(pF, 1100);
		testFlight.cancelBooking(pE2, 1130);
		testFlight.cancelBooking(pB3, 1130);
		testFlight.cancelBooking(pP, 1130);
		testFlight.upgradeBookings();
		assertEquals(2, testFlight.getNumPremium());
		assertEquals(2, testFlight.getNumFirst());
		assertEquals(1, testFlight.getNumBusiness());
		assertEquals(5, testFlight.getNumPassengers());
	}
	
	/**
	 * A test that ensures that list of passengers adds correctly
	 * 
	 * @throws AircraftException
	 * @throws PassengerException
	 */
	@Test
	public void getPassengersTest() throws AircraftException, PassengerException {
		List<Passenger> testList = new ArrayList<Passenger>();
		Economy pE = new Economy(900,1200);
		Economy pE2 = new Economy(1100,1200);
		First pF = new First(1100,1200);
		A380 testFlight = new A380("SEA111", 1200);
		testList.add(pE);
		testList.add(pE2);
		testList.add(pF);		
		testFlight.confirmBooking(pE, 1100);
		testFlight.confirmBooking(pE2, 1100);
		testFlight.confirmBooking(pF, 1100);
		assertEquals(testList, testFlight.getPassengers());
	}

}
