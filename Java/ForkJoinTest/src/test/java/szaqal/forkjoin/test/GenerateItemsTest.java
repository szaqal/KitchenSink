package szaqal.forkjoin.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.junit.Test;

import szaqal.forkjoin.ExecutionContext;
import szaqal.forkjoin.GenerateItemsTask;
import szaqal.forkjoin.formatters.ItemFormatter;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class GenerateItemsTest {

	@Test
	public void testGenerate() {
		
		ExecutionContext context = new ExecutionContext();
		context.setQty("10");
		context.setType("COMPANY");
		context.setFormatterType(ItemFormatter.TYPES.PLAIN);
		List<String> generated =  new ForkJoinPool().invoke(new GenerateItemsTask(context));
		assertEquals(10, generated.size());
	}
}
