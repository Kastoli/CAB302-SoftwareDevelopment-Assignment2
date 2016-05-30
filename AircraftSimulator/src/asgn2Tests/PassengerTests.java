
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.Economy;
import asgn2Passengers.Premium;
import asgn2Passengers.PassengerException;

/**
 * @author Liam Dinsdale
 *
 */
public class PassengerTests {

	/**
	 * A simple test to ensure the queuePassenger() function works correctly for newState passengers.
	 * 
	 * @throws PassengerException 
	 */
	@Test
	public void newStateQueuedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.queuePassenger(20, myPassenger.getDepartureTime());
		assertTrue(myPassenger.isQueued());
		assertEquals(myPassenger.getEnterQueueTime(),20);
	}
	
	/**
	 * A simple test to ensure the confirmSeat() function works correctly for newState passengers.
	 * 
	 * @throws PassengerException 
	 */
	@Test
	public void newStateConfirmedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.confirmSeat(20, myPassenger.getDepartureTime());
		assertTrue(myPassenger.isConfirmed());
		assertEquals(myPassenger.getConfirmationTime(),20);
	}
	
	/**
	 * A simple test to ensure the refusePassenger() function works correctly for newState passengers.
	 * 
	 * @throws PassengerException 
	 */
	@Test
	public void newStateRefusedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.refusePassenger(20);
		assertTrue(myPassenger.isRefused());
	}
	
	/**
	 * A simple test to ensure the confirmSeat() function works correctly for queued passengers.
	 * 
	 * @throws PassengerException 
	 */
	@Test
	public void queuedConfirmedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.queuePassenger(20, myPassenger.getDepartureTime());
		myPassenger.confirmSeat(30, myPassenger.getDepartureTime());
		assertTrue(myPassenger.isConfirmed());
		assertEquals(myPassenger.getConfirmationTime(),30);
		assertEquals(myPassenger.getExitQueueTime(),30);
	}
	
	/**
	 * A simple test to ensure the refusePassenger() function works correctly for queued passengers.
	 * 
	 * @throws PassengerException 
	 */
	@Test
	public void queuedRefusedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.queuePassenger(20, myPassenger.getDepartureTime());
		myPassenger.refusePassenger(30);
		assertTrue(myPassenger.isRefused());
		assertEquals(myPassenger.getExitQueueTime(),30);
	}
	
	/**
	 * A simple test to ensure the cancelSeat() function works correctly for confirmed passengers.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void confirmedCancelSeatTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.confirmSeat(20, myPassenger.getDepartureTime());
		myPassenger.cancelSeat(30);
		assertTrue(myPassenger.isNew());
		assertEquals(myPassenger.getBookingTime(), 30);
	}
	
	/**
	 * A simple test to ensure the flyPassenger() function works correctly for confirmed passengers.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void confirmedFlyPassengerTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.confirmSeat(20, myPassenger.getDepartureTime());
		myPassenger.flyPassenger(30);
		assertTrue(myPassenger.isFlown());
	}
	
	/**
	 * A simple test to ensure the wasConfirmed() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void wasConfirmedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		assertFalse(myPassenger.wasConfirmed());
		myPassenger.confirmSeat(20, myPassenger.getDepartureTime());
		assertTrue(myPassenger.wasConfirmed());
		myPassenger.flyPassenger(30);
		assertTrue(myPassenger.wasConfirmed());
		
		Economy myOtherPassenger = new Economy(10,100);
		assertFalse(myOtherPassenger.wasConfirmed());
		myOtherPassenger.confirmSeat(20, myOtherPassenger.getDepartureTime());
		assertTrue(myOtherPassenger.wasConfirmed());
		myOtherPassenger.cancelSeat(30);
		assertTrue(myOtherPassenger.wasConfirmed());
	}
	
	/**
	 * A simple test to ensure the wasQueued() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void wasQueuedTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		assertFalse(myPassenger.wasQueued());
		myPassenger.queuePassenger(20, myPassenger.getDepartureTime());
		assertTrue(myPassenger.wasQueued());
		myPassenger.confirmSeat(30, myPassenger.getDepartureTime());
		assertTrue(myPassenger.wasQueued());
		
		Economy myOtherPassenger = new Economy(10,100);
		assertFalse(myOtherPassenger.wasQueued());
		myOtherPassenger.queuePassenger(20, myOtherPassenger.getDepartureTime());
		assertTrue(myOtherPassenger.wasQueued());
		myOtherPassenger.refusePassenger(30);
		assertTrue(myPassenger.wasQueued());
	}
	
	/**
	 * A simple test to ensure the copyPassengerState() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void copyPassengerStateTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		myPassenger.queuePassenger(20, myPassenger.getDepartureTime());
		myPassenger.confirmSeat(30, myPassenger.getDepartureTime());
		assertEquals(myPassenger.getEnterQueueTime(),20);
		assertEquals(myPassenger.getExitQueueTime(),30);
		assertEquals(myPassenger.getConfirmationTime(),30);
		Premium upgradedPassenger = (Premium) myPassenger.upgrade();
		assertEquals(upgradedPassenger.getEnterQueueTime(),20);
		assertEquals(upgradedPassenger.getExitQueueTime(),30);
		assertEquals(upgradedPassenger.getConfirmationTime(),30);
	}
}
