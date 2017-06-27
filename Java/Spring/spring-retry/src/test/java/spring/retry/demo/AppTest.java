package spring.retry.demo;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest  {
	
	@Test
	public void testRetrySupported() throws Exception  {
		
		for(int i=0;i<2;i++) {
			new App().invokeWithRetrySupport();
		}
	}
	
	@Test(expected=NumberFormatException.class)
	public void testRetryNotSupported() throws Exception  {
		
		for(int i=0;i<2;i++) {
			new App().invokeWithoutRetrySupport();
		}
	}
}
