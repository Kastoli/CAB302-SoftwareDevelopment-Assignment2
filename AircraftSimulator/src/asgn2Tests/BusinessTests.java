
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

import asgn2Passengers.Business;
import asgn2Passengers.First;
import asgn2Passengers.PassengerException;

/**
 * @author Liam Dinsdale
 *
 */
public class BusinessTests {

	/**
	 * A simple test to ensure the constructor works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void constructorTest() throws PassengerException {
		Business myPassenger = new Business(10,100);
		assertNotNull(myPassenger);
	}
	
	/**
	 * A simple test to ensure the noSeatsMsg() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void noSeatsMsgTest() throws PassengerException {
		Business myPassenger = new Business(10,100);
		assertEquals("No seats available in Business", myPassenger.noSeatsMsg());
	}
	
	/**
	 * A simple test to ensure the upgrade() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void upgradeTest() throws PassengerException {
		Business businessPassenger = new Business(10,100);
		assertEquals("J:1", businessPassenger.getPassID());
		assertThat(businessPassenger, instanceOf(Business.class));
		First firstPassenger = (First) businessPassenger.upgrade();
		assertThat(firstPassenger, instanceOf(First.class));
		assertEquals("F(U)J:1", firstPassenger.getPassID());
	}
}
