package spring.retry.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class App {

	private static Logger LOG = LoggerFactory.getLogger(App.class);

	private RetryTemplate retryTemplate = new RetryTemplate();

	private RetryMethods retryMethods = new RetryMethods();

	public void invokeWithRetrySupport() {
		LOG.info("Running WITH RETRY");

		try {
			retryTemplate.execute(new RetryCallback<Double>() {

				public Double doWithRetry( RetryContext arg0 ) throws Exception {
					LOG.info("\tRetry count ->  {} ", arg0.getRetryCount());
					return retryMethods.doRetrySupported();
				}
			});
		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

	public void invokeWithoutRetrySupport() throws Exception {
		LOG.info("Running WITHOUT RETRY");

		retryTemplate.execute(new RetryCallback<Double>() {

			public Double doWithRetry( RetryContext arg0 ) throws Exception {
				LOG.info("\tRetry count ->  {} ", arg0.getRetryCount());
				return retryMethods.doRetryNotSupported();
			}
		});

	}

	{
		Map<Class<? extends Throwable>, Boolean> retryableExceptions = new HashMap<Class<? extends Throwable>, Boolean>();
		retryableExceptions.put(IOException.class, true);

		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(500);
		backOffPolicy.setMaxInterval(20000);
		backOffPolicy.setMultiplier(1.5);

		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(10, retryableExceptions);
		retryPolicy.setMaxAttempts(10);

		retryTemplate.setRetryPolicy(retryPolicy);
		retryTemplate.setBackOffPolicy(backOffPolicy);
	}
}
