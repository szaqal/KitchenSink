package szaq.logback.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import szaq.logback.demo.model.User;
import szaq.logback.demo.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserServiceTest {


	@Resource
	private UserService userService;

	@Test
	public void testWiring() {
		assertNotNull(userService);
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


}
