package szaqal.forkjoin.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import szaqal.forkjoin.enums.StringItemType;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class ItemTypeTest {

	@Test
	public void testCount() {
		assertEquals(5, StringItemType.values().length);
	}
	
	@Test
	public void testValueOf() {
		assertEquals(StringItemType.COMPANY, StringItemType.valueOf("COMPANY"));
	}
}
