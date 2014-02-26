package szaq.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class SpringBootApplication {
	
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ApplicationConfig.class);
		springApplication.setWebEnvironment(false);
		ConfigurableApplicationContext run = springApplication.run(args);
		run.publishEvent(new ApplicationStartedEvent(springApplication, args));
	}
}
