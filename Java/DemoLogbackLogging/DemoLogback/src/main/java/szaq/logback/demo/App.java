package szaq.logback.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class App {
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		LOG.info("Application initialized " + ctx);
	}
}
