package szaq.spring.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Spring Boot AutoConfiguration attempts to automatically configure your Spring application based on the dependencies that it declares
 * 
 * @author malczyk.pawel@gmail.com
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationConfig {

}
