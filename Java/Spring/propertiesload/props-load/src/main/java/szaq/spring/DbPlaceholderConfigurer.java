package szaq.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

public class DbPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {
	
	private static final Logger LOG = LoggerFactory.getLogger(DbPlaceholderConfigurer.class);
	
	
	public DbPlaceholderConfigurer(EmbeddedDatabase dataSource) {
		
		try {
			Map<String, Object> loadedSettings = loadProperties(dataSource);
			MutablePropertySources mutablePropertySources = new MutablePropertySources();
			mutablePropertySources.addFirst(new MapPropertySource("custom", loadedSettings));
			setPropertySources(mutablePropertySources);
		} catch (SQLException e) {
			LOG.error("Error loading properties", e);
		}
		

	}

	private Map<String, Object> loadProperties(EmbeddedDatabase dataSource) throws SQLException {
		LOG.info("{}",dataSource);
		Connection connection =  dataSource.getConnection();
		PreparedStatement prepareStatement =connection.prepareStatement("SELECT * FROM Settings");
		Map<String, Object> loadedSettings = new HashMap<String, Object>();
		prepareStatement.execute();
		ResultSet resultSet = prepareStatement.getResultSet();
		while(resultSet.next()){
			loadedSettings.put(resultSet.getString(2), resultSet.getString(3));
		}
		connection.close();
		return loadedSettings;
	}
}
