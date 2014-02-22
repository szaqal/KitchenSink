package szaq.spring.boot;

import java.io.IOException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

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
@EnableConfigurationProperties(ApplicationSetup.class)
public class ApplicationConfig {

	@Bean
	public PropertySource<?> yamlPropertySourceLoader() throws IOException {
		YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
		PropertySource<?> applicationYamlPropertySource = loader.load(
				"application.yml", new ClassPathResource("application.yml"),"default");
		return applicationYamlPropertySource;
	}
}
