package szaqal.guava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class TestHashing {

	@Test
	public void testMd5() {
		HashFunction md5 = Hashing.md5();
		HashCode hashString = md5.hashString("BeforeHash", Charset.defaultCharset());
		assertEquals("86b3a7bd44852cf9cc897e262ccb4edd", hashString.toString());
	}
	
	@Test
	public void testSha512() {
		HashFunction sha512 = Hashing.sha512();
		HashCode hashString = sha512.hashString("BeforeHash", Charset.defaultCharset());
		assertEquals("12ccc1ec7265c18840ab0b5b70b8b776fca4015f3ed62eb0d2c2bf727fe8e108b77e9f49458e47e98d852861b8a0bb83a9b5dd4fe84f89ce3d5fe6623142426f", hashString.toString());
	}
	
}
