package szaqal.guava.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class FunctionsTest {

	@Test
	public void testConstant() {
		Function<Object, String> constant = Functions.constant("CONSTANT");
		assertEquals("CONSTANT", constant.apply("TEST"));
	}
	
	@Test
	public void testToString() {
		Function<Object, String> stringFunction = Functions.toStringFunction();
		assertEquals("HI", stringFunction.apply(new TestClass()));
	}
	
	@Test
	public void testForMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "val1");
		map.put("key2", "val2");
		map.put("key3", "val3");
		Function<String, String> forMap = Functions.forMap(map);
		assertEquals("val2", forMap.apply("key2"));
		Function<String, String> forMap2 = Functions.forMap(map, "zzz");
		assertEquals("zzz", forMap2.apply("rubbish"));
		Function<String, String> identity = Functions.identity();
		assertEquals("fff", identity.apply("fff"));
	}
	
	public class TestClass {
		
		@Override
		public String toString() {
			return "HI";
		}
	}
}
