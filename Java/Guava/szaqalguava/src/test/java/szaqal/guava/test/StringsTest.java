package szaqal.guava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class StringsTest {

	@Test
	public void testCommonPrefix() {
		String str1 = "aaafghhy";
		String str2 = "aaagbbgh";
		assertEquals("aaa", Strings.commonPrefix(str1, str2));
	}
	
	@Test
	public void testCommonSuffix() {
		String str1 = "nnnmkk";
		String str2 = "hhgkmk";
		assertEquals("k", Strings.commonSuffix(str1, str2));
	}
	
	@Test
	public void testRepeat() {
		String str = "jjuu";
		assertEquals("jjuujjuu", Strings.repeat(str, 2));
	}
	
	@Test
	public void testPadEnd() {
		String str = "JJUU";
		assertEquals("JJUUzz", Strings.padEnd(str, 6, 'z'));
	}
	
	@Test
	public void testPadStart() {
		String str = "JJUU";
		assertEquals("xxJJUU", Strings.padStart(str, 6, 'x'));
	}
	
	@Test
	public void testCharMatcher() {
		assertFalse(CharMatcher.DIGIT.matches('d'));
		assertTrue(CharMatcher.DIGIT.matches('5'));
		assertTrue(CharMatcher.DIGIT.and(CharMatcher.ANY).matches('5'));
		assertTrue(CharMatcher.JAVA_UPPER_CASE.or(CharMatcher.JAVA_LOWER_CASE).or(CharMatcher.DIGIT).matches('5'));
		assertNotNull(CharMatcher.anyOf("55"));
		
		CharMatcher matcher = CharMatcher.forPredicate(new Predicate<Character>() {

			@Override
			public boolean apply(Character character) {
				return 'a' == character;
			}
		});
		assertTrue(matcher.matches('a'));
		
		assertEquals("hhhbhh",matcher.collapseFrom("hhhaaahh", 'b'));
		assertEquals(Integer.valueOf(3), Integer.valueOf(matcher.countIn("hhhaaahh")));
		assertTrue(CharMatcher.DIGIT.matchesAllOf("5555"));
		assertFalse(CharMatcher.DIGIT.matchesAllOf("5555g"));
		assertTrue(CharMatcher.DIGIT.matchesNoneOf("ttt"));
		assertTrue(CharMatcher.DIGIT.matchesAnyOf("t5tt"));
		assertEquals("ttt", CharMatcher.DIGIT.removeFrom("t5tt"));
		assertEquals("5", CharMatcher.DIGIT.retainFrom("t5tt"));
	}
}
