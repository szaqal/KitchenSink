package szaq.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class ApplicationRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationRunner.class);

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(QuartzApp.class);
		LOG.info("Application initialized " + ctx);
	}

}
