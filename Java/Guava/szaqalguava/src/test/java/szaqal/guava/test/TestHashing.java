package szaqal.guava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class TestHashing {

	@Test
	public void testMd5() {
		HashFunction md5 = Hashing.md5();
		HashCode hashString = md5.hashString("BeforeHash");
		assertEquals("07eb52c22edb599f5c18201c40cd23cb", hashString.toString());
	}
	
	@Test
	public void testSha512() {
		HashFunction sha512 = Hashing.sha512();
		HashCode hashString = sha512.hashString("BeforeHash");
		assertEquals("5c399c789482907b556b07ee383907bf6ea368b497b22949ba78e3969e06151815ae7adc59686057fc8c961cdc869bf84c1bdbf8a96d69e1b15ebc24bb60b8c6", hashString.toString());
	}
	
}
