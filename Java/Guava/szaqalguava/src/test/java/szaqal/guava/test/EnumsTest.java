package szaqal.guava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.google.common.base.Enums;
import com.google.common.base.Function;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class EnumsTest {
	
	@Test
	public void testEnumsGetIfPresent() {
		Items item = Enums.getIfPresent(Items.class, "ITEM_1").or(Items.DEFAULT);
		Items defaultItem = Enums.getIfPresent(Items.class, "ITEM_9").or(Items.DEFAULT);
		assertEquals(Items.ITEM_1, item);
		assertEquals(Items.DEFAULT, defaultItem);
	}
	
	@Test
	public void testValueOfFunction() {
		Function<String, Items> function = Enums.valueOfFunction(Items.class);
		assertEquals(Items.ITEM_1, function.apply("ITEM_1"));
		assertNull(function.apply("ITEM_9"));
	}
	

	public enum Items {
		ITEM_1,
		ITEM_2,
		ITEM_3,
		DEFAULT
	}
	
}
