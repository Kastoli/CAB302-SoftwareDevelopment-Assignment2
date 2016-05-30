package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Aircraft.*;
import asgn2Passengers.*;

public class AircraftTests {

	@Test
	public void ConstructorAircraftTest() throws AircraftException {
		A380 testFlight = new A380("SEA111", 1200);
		assertTrue(testFlight.flightEmpty());
		assertEquals(484, testFlight.getBookings().getAvailable());
	}
	
	@Test
	public void ConstructorAircraftTest2() throws AircraftException {
		B747 testFlight = new B747("SEA111", 1200);
		assertTrue(testFlight.flightEmpty());
		assertEquals(353, testFlight.getBookings().getAvailable());
	}
	
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

}
