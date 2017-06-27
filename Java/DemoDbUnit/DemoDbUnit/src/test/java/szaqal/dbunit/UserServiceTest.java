package szaqal.dbunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import szaqal.dbunit.model.User;
import szaqal.dbunit.services.UserService;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserServiceTest {

	@Resource
	private DataSourceDatabaseTester dataSourceDatabaseTester;

	@Resource
	private UserService userService;

	@Test
	public void testWiring() {
		assertNotNull(userService);
		assertNotNull(dataSourceDatabaseTester);
	}

	@Test
	public void testStore() {
		User user = new User();
		user.setId(200);
		user.setFirstName("Pawel");
		user.setLastName("Malczyk");
		userService.store(user);
		User verifyUser = userService.get(200);
		assertNotNull(verifyUser);
		assertEquals("Pawel", verifyUser.getFirstName());
		assertEquals("Malczyk", verifyUser.getLastName());
	}

	@Test
	public void testGet() throws Exception {
		final IDatabaseConnection connection = dataSourceDatabaseTester.getConnection();
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		ClassPathResource resource = new ClassPathResource("user.xml");
		DatabaseOperation.CLEAN_INSERT.execute(connection,builder.build(resource.getFile()));
		User verifyUser = userService.get(3);
		assertEquals("Zygmunt", verifyUser.getFirstName());
		assertEquals("Kowalski", verifyUser.getLastName());
	}

}
