
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

import asgn2Passengers.Premium;
import asgn2Passengers.Business;
import asgn2Passengers.PassengerException;

/**
 * @author Liam Dinsdale
 *
 */
public class PremiumTests {

	/**
	 * A simple test to ensure the constructor works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void constructorTest() throws PassengerException {
		Premium myPassenger = new Premium(10,100);
		assertNotNull(myPassenger);
	}
	
	/**
	 * A simple test to ensure the noSeatsMsg() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void noSeatsMsgTest() throws PassengerException {
		Premium myPassenger = new Premium(10,100);
		assertEquals("No seats available in Premium", myPassenger.noSeatsMsg());
	}
	
	/**
	 * A simple test to ensure the upgrade() function works correctly.
	 * 
	 * @throws PassengerException
	 */
	@Test
	public void upgradeTest() throws PassengerException {
		Premium premiumPassenger = new Premium(10,100);
		assertThat(premiumPassenger, instanceOf(Premium.class));
		assertEquals("P:1", premiumPassenger.getPassID());
		Business businessPassenger = (Business) premiumPassenger.upgrade();
		assertEquals("J(U)P:1", businessPassenger.getPassID());
		assertThat(businessPassenger, instanceOf(Business.class));
	}
}
