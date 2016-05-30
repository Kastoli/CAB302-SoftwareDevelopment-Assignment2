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
	}
	
	@Test
	public void ConstructorAircraftTest2() throws AircraftException {
		B747 testFlight = new B747("SEA111", 1200);
		assertTrue(testFlight.flightEmpty());
	}
	
	@Test
	public void confirmBookingTest() throws AircraftException, PassengerException {
		Economy pE = new Economy(1000,1200);
		A380 testFlight = new A380("SEA111", 1200);
		testFlight.confirmBooking(pE, 1100);
		assertEquals(1, testFlight.getNumEconomy());
		assertEquals(1, testFlight.getNumPassengers());
		assertTrue(testFlight.hasPassenger(pE));
	}

}