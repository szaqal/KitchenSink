package szaq.jooq.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.jooq.Record2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
public class ApplicationTest {

	@Resource
	private AuthorService authorService;

	@Test
	public void testService() {
		assertNotNull(authorService);
		authorService.save(1, "testFirstaName", "testLastName");
		Record2<String, String> record2 = authorService.get();
		assertEquals("testFirstaName", record2.value1());
		assertEquals("testLastName", record2.value2());
		
	}
}
