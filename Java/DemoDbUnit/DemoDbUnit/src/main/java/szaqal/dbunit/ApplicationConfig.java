package szaqal.dbunit;

import org.apache.ibatis.session.SqlSessionFactory;
import org.dbunit.DataSourceDatabaseTester;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import szaqal.dbunit.dao.UserDao;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
@Configuration
@ComponentScan({ "szaqal.dbunit.services" })
@MapperScan("szaqal.dbunit.dao")
public class ApplicationConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public UserDao userDao() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sessionTemplate.getMapper(UserDao.class);
	}

	@Bean
	public EmbeddedDatabase dataSource() {
		EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
		databaseBuilder.addScript("classpath:schema.sql");
		databaseBuilder.setName("test");
		databaseBuilder.setType(EmbeddedDatabaseType.HSQL);
		return databaseBuilder.build();
	}
	
	@Bean
	public DataSourceDatabaseTester databaseTester() {
		return new DataSourceDatabaseTester(dataSource());
	}
}
