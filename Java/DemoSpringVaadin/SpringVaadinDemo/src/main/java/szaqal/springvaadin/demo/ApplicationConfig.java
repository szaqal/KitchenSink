package szaqal.springvaadin.demo;

import org.springframework.beans.factory.aspectj.EnableSpringConfigured;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Configuration
@ComponentScan({ "szaqal.springvaadin.demo" })
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableSpringConfigured
public class ApplicationConfig {

	
	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
}
