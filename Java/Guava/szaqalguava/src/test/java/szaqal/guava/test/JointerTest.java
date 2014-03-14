package szaqal.guava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class JointerTest {

	@Test
	public void testJoiner() {
		String joined = Joiner.on(";").join(new String[]{"a","b"});
		assertEquals("a;b", joined);
		joined = Joiner.on(";").join("c", "d");
		assertEquals("c;d", joined);
		StringBuilder builder = new StringBuilder("dupa");
		StringBuilder appendTo = Joiner.on(";").appendTo(builder, "d","c");
		assertEquals("dupad;c", appendTo.toString());
		joined = Joiner.on(";").useForNull("NULL").join(new String[]{"a","b",null});
		assertEquals("a;b;NULL", joined);
		joined = Joiner.on(";").skipNulls().join(new String[]{"a","b"});
		assertEquals("a;b", joined);
	}
}
