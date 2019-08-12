package szaqal.leak;

import java.util.Arrays;

public class TestClass {

	private byte[] data;

	public TestClass() {
		super();
		this.data = new byte[1024*10];
		Arrays.fill(this.data, (byte)9);
	}
	
}
