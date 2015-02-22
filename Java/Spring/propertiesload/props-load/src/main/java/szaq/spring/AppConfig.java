package szaq.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan({ "szaq.spring" })
public class AppConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);
	
	private static EmbeddedDatabase dataSource;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new DbPlaceholderConfigurer(dataSource());
	}
	
	
	@Bean
	public static EmbeddedDatabase dataSource() {
		if(dataSource == null) {
			EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
			databaseBuilder.addScript("classpath:schema.sql");
			databaseBuilder.setName("test");
			databaseBuilder.setType(EmbeddedDatabaseType.HSQL);
			EmbeddedDatabase build = databaseBuilder.build();
			initPopulate(build);
			dataSource = build;
		}
		return dataSource;
	}
	
	private static void initPopulate(EmbeddedDatabase embeddedDatabase) {
		try {
			Connection connection = embeddedDatabase.getConnection();
			PreparedStatement prepareStatement;
			prepareStatement = connection.prepareStatement("INSERT INTO Settings VALUES (?,?,?)");
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "testKey");
			prepareStatement.setString(3, "testVal");
			prepareStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			LOG.error("Error ", e);
		}

	}
}
