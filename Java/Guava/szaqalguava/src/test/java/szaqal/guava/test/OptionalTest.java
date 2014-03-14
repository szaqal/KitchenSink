package szaqal.guava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Optional;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class OptionalTest {
	
	@Test
	public void testOptional() {
		Optional<String> absent = Optional.<String>absent();
		assertFalse(absent.isPresent());
		assertEquals("sss",empty().or("sss"));
		assertEquals("fff",useOptional(absent));
		assertEquals("zzzz_transformed", useOptional2(Optional.<String>of("zzzz")));
	}
	
	private Optional<String> empty() {
		return Optional.<String>absent();
	}
	
	private String useOptional(Optional<String> item) {
		String argument = item.or("fff");
		return argument;
	}
	
	private String useOptional2(Optional<String> item) {
		 Optional<String> transform = item.transform(new Function<String, String>() {

			@Override
			public String apply(String item) {
				return item+"_transformed";
			}
		});
		 return transform.get();
	}

}
