package szaq.jooq.demo;

import javax.sql.DataSource;

import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Configuration
@ComponentScan("szaq.jooq.demo")
@EnableTransactionManagement
public class ApplicationConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);
	

	@Bean
	public DataSourceTransactionManager transactionManger() {
		LOG.info("Transaction manager initialized");
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public BoneCPDataSource dataSource() {
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
		boneCPDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/userlibrary");
		boneCPDataSource.setUsername("dh");
		boneCPDataSource.setPassword("dh123");
		LOG.info("DS initialized");
		return boneCPDataSource;
	}

	@Bean
	public DefaultDSLContext dsl() {
		LOG.info("DSL Initialized");
		return new DefaultDSLContext(config());
	}
	
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
		return new DataSourceConnectionProvider(dataSource());
	}
	
	@Bean
	public DefaultConfiguration config() {
		LOG.info("JOOQ Config");
		DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
		defaultConfiguration.set(connectionProvider());
		defaultConfiguration.set(SQLDialect.MYSQL);
		return defaultConfiguration;
	}
}
