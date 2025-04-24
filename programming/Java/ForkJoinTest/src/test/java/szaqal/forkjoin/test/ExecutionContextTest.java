package szaqal.forkjoin.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.junit.Test;

import szaqal.forkjoin.App;
import szaqal.forkjoin.ExecutionContext;
import szaqal.forkjoin.formatters.ItemFormatter.TYPES;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class ExecutionContextTest {

	@Test
	public void testExec() {
		ExecutionContext context = new ExecutionContext();
		context.setFileName("fileName");
		context.setFormatter("formatter");
		context.setFormatterType(TYPES.CSV);
		context.setType("type");
		context.setQty("2");
		assertEquals("fileName", context.getFileName());
		assertEquals("formatter", context.getFormatter());
		assertEquals(TYPES.CSV, context.getFormatterType());
		assertEquals("type", context.getType());
		assertEquals("2", context.getQty());
	}

	@Test
	public void testExecParse() throws ParseException {
		String[] args = new String[] { "-qty", "2", "-type", "MALE_PERSON", "-format", "XML", "-filename", "/tmp/zzz.txt" };
		CommandLineParser parser = new PosixParser();
		CommandLine line = parser.parse(App.OPTIONS, args);
		ExecutionContext context = ExecutionContext.build(line);
		assertEquals("/tmp/zzz.txt", context.getFileName());
		assertEquals("XML", context.getFormatter());
		assertEquals("MALE_PERSON", context.getType());
		assertEquals("2", context.getQty());
	}
	
	@Test(expected=ParseException.class)
	public void testMissing() throws ParseException {
		String[] args = new String[] { "-qty", "2", "-format", "XML", "-filename", "/tmp/zzz.txt" };
		CommandLineParser parser = new PosixParser();
		CommandLine line = parser.parse(App.OPTIONS, args);
		ExecutionContext.build(line);
	}
	
	
	@Test(expected=ParseException.class)
	public void testMissing1() throws ParseException {
		String[] args = new String[] { "-qty", "2", "-type", "MALE_PERSON", "-format", "XML" };
		CommandLineParser parser = new PosixParser();
		CommandLine line = parser.parse(App.OPTIONS, args);
		ExecutionContext.build(line);
	}
	
	@Test(expected=ParseException.class)
	public void testMissing2() throws ParseException {
		String[] args = new String[] { "-format", "XML", "-filename", "/tmp/zzz.txt" };
		CommandLineParser parser = new PosixParser();
		ExecutionContext.build(parser.parse(App.OPTIONS, args));
	}
}
