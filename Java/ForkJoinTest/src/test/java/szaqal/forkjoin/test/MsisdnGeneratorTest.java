package szaqal.forkjoin.test;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;

import szaqal.forkjoin.formatters.PlainFormatter;
import szaqal.forkjoin.generators.CanadaMsisdnGenerator;
import szaqal.forkjoin.generators.UsMsisdnGenerator;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class MsisdnGeneratorTest {
	

	@Test
	public void testUsMsisdn() {
		String msisdn = new UsMsisdnGenerator().generateItem(new PlainFormatter());
		System.out.println(msisdn);
		boolean matched = Pattern.matches(UsMsisdnGenerator.US_MSISDN_REGEX, msisdn);
		assertTrue(matched);
	}
	
	@Test
	public void testCanadaMsisdn() {
		String msisdn = new CanadaMsisdnGenerator().generateItem(new PlainFormatter());
		boolean matched = Pattern.matches(CanadaMsisdnGenerator.CANADA_MSISDN_REGEX, msisdn);
		assertTrue(matched);
	}
}
