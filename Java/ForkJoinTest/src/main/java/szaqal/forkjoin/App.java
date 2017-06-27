package szaqal.forkjoin;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static final Options OPTIONS = new Options();

	static {
		OPTIONS.addOption(ExecutionContext.buildQtyOption());
		OPTIONS.addOption(ExecutionContext.buildTypeOption());
		OPTIONS.addOption(ExecutionContext.buildFileNameOption());
		OPTIONS.addOption(ExecutionContext.buildFormatOption());
	}

	public static final int CORE_COUNT = Runtime.getRuntime().availableProcessors();

	public static ForkJoinPool POOL = new ForkJoinPool(CORE_COUNT);

	public static void main(String[] args) throws IOException {
		CommandLineParser parser = new PosixParser();
		try {
			CommandLine line = parser.parse(OPTIONS, args);
			ExecutionContext context = ExecutionContext.build(line);

			LOG.info("Application started with {} processors ", CORE_COUNT);
			List<String> generatedItems = POOL.invoke(new GenerateItemsTask(context));

			storeFile(context.getFileName(), generatedItems);
		} catch (ParseException exp) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("ForkJoin", OPTIONS);
			LOG.warn("Parsing failed.  Reason: " + exp.getMessage());
		} catch (URISyntaxException e) {
			LOG.error("Invalid filename given");
		}
		LOG.info("Done");
	}

	private static void storeFile(String fileName, List<String> result) throws IOException, URISyntaxException {
		Path filePath = Paths.get(new URI("file://" + fileName));
		Files.deleteIfExists(filePath);
		BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.defaultCharset());
		for (String item : result) {
			writer.write(item);
			writer.newLine();
		}
		writer.flush();
	}

}
