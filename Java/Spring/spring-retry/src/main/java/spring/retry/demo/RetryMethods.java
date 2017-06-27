package spring.retry.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class RetryMethods {

	private static final Logger LOG = LoggerFactory.getLogger(RetryMethods.class);
	
	public double doRetrySupported() throws IOException {
		double random = Math.random();
		if(random < 0.5) {
			LOG.info("\tThrowing IOException");
			throw new IOException("Retry is supported here");
		}
		LOG.info("-> {}", random);
		return random;
	}
	
	public double doRetryNotSupported()  {
		LOG.info("\tThrowing Exception");
		throw new NumberFormatException("Retry is not supported here");
	}
}
