package szaq.spring.boot;

import liquibase.integration.spring.SpringLiquibase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationConfig {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);
	
	@Bean
	public EmbeddedDatabase dataSource() {
		EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
		databaseBuilder.setName("test");
		databaseBuilder.setType(EmbeddedDatabaseType.HSQL);
		return databaseBuilder.build();
	}
	@Bean
	public SpringLiquibase springLiquibase() {
		SpringLiquibase springLiquibase = new SpringLiquibase();
		springLiquibase.setDataSource(dataSource());
		springLiquibase.setChangeLog("classpath:changelog.xml");
		return springLiquibase;
	}
	
	@Bean
	public ApplicationListener<ApplicationStartedEvent> customListener() {
		return new ApplicationListener<ApplicationStartedEvent> () {

			@Override
			public void onApplicationEvent(ApplicationStartedEvent arg0) {
				LOG.info("APPLICATION STARTED");
			}
			
		};
	}
	
}
