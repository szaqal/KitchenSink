package szaq.spring;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class AppTest {
	
	@Autowired
	private SettingService settingService;
	
	@Test
	public void testSettings() {
		assertEquals("testVal", settingService.getValue());
	}
}
