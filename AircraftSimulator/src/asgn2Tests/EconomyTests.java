
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

import asgn2Passengers.Economy;
import asgn2Passengers.Premium;
import asgn2Passengers.PassengerException;

/**
 * @author Liam Dinsdale
 *
 */
public class EconomyTests {

	/**
	 * A simple test to ensure the constructor works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void constructorTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		assertNotNull(myPassenger);
	}
	
	/**
	 * A simple test to ensure the noSeatsMsg() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void noSeatsMsgTest() throws PassengerException {
		Economy myPassenger = new Economy(10,100);
		assertEquals("No seats available in Economy", myPassenger.noSeatsMsg());
	}
	
	/**
	 * A simple test to ensure the upgrade() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void upgradeTest() throws PassengerException {
		Economy economyPassenger = new Economy(10,100);
		assertThat(economyPassenger, instanceOf(Economy.class));
		assertEquals("Y:1", economyPassenger.getPassID());		
		Premium premiumPassenger = (Premium) economyPassenger.upgrade();
		assertThat(premiumPassenger, instanceOf(Premium.class));
		assertEquals("P(U)Y:1", premiumPassenger.getPassID());
	}
}
