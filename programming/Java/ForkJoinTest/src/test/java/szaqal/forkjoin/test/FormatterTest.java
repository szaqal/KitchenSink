package szaqal.forkjoin.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import szaqal.forkjoin.formatters.CsvFormatter;
import szaqal.forkjoin.formatters.ItemFormatter;
import szaqal.forkjoin.formatters.PlainFormatter;
import szaqal.forkjoin.formatters.XmlFormatter;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class FormatterTest {

	@Test
	public void testPlain() {
		PlainFormatter plainFormatter = new PlainFormatter();
		assertEquals("dddd", plainFormatter.format("dddd"));
	}
	
	@Test
	public void testCsv() {
		CsvFormatter formatter = new CsvFormatter();
		assertEquals("\"ddd\"", formatter.format("ddd"));
	}
	
	@Test
	public void testXml() {
		assertEquals("<item>ddd</item>", new XmlFormatter().format("ddd"));
	}
	
	@Test
	public void testTypes() {
		assertEquals(ItemFormatter.TYPES.CSV, ItemFormatter.TYPES.valueOf("CSV"));
		assertEquals(3, ItemFormatter.TYPES.values().length);
	}
}
