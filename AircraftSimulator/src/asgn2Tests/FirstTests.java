
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Passengers.First;
import asgn2Passengers.PassengerException;

/**
 * @author Liam Dinsdale
 *
 */
public class FirstTests {

	/**
	 * A simple test to ensure the constructor works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void constructorTest() throws PassengerException{
		First myPassenger = new First(10,100);
		assertNotNull(myPassenger);
	}
	
	/**
	 * A simple test to ensure the noSeatsMsg() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void noSeatsMsgTest() throws PassengerException {
		First myPassenger = new First(10,100);
		assertEquals("No seats available in First", myPassenger.noSeatsMsg());
	}
	
	/**
	 * A simple test to ensure the upgrade() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void upgradeTest() throws PassengerException {
		First myPassenger = new First(10,100);
		assertEquals(myPassenger, myPassenger.upgrade());
	}
}
