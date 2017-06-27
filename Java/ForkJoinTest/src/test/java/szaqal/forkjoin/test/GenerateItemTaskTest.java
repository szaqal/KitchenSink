package szaqal.forkjoin.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.junit.Test;

import szaqal.forkjoin.GenerateItemTask;
import szaqal.forkjoin.enums.StringItemType;
import szaqal.forkjoin.formatters.ItemFormatter;
import szaqal.forkjoin.formatters.PlainFormatter;
import szaqal.forkjoin.generators.AbstractItemGenerator;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class GenerateItemTaskTest {

	@Test
	public void testGenerateItemMale() throws Exception {
		
		
		
		GenerateItemTask itemTask = new GenerateItemTask(10, StringItemType.MALE_PERSON);
		new ForkJoinPool().execute(itemTask);
		List<String> result = itemTask.get();
		assertNotNull(result);
		assertEquals(10, result.size());
	}
	
	@Test
	public void testGenerateItemFemale() throws Exception {
		GenerateItemTask itemTask = new GenerateItemTask(5, StringItemType.FEMALE_PERSON);
		new ForkJoinPool().execute(itemTask);
		List<String> result = itemTask.get();
		assertNotNull(result);
		assertEquals(5, result.size());
	}
	
	@Test
	public void testGenerateItemCompany() throws Exception {
		GenerateItemTask itemTask = new GenerateItemTask(2, StringItemType.COMPANY);
		new ForkJoinPool().execute(itemTask);
		List<String> result = itemTask.get();
		assertNotNull(result);
		assertEquals(2, result.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void testException() {
		AbstractItemGenerator<String> itemGenerator = new AbstractItemGenerator<String>() {
			
			@Override
			public String generateItem(ItemFormatter<String> itemFormatter) {
				loadAll("invalidFileName");
				return "";
			}
		};
		assertNotNull(itemGenerator.generateItem(new PlainFormatter()));
	}
}
