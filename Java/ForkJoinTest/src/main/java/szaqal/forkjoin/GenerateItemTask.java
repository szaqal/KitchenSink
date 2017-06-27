package szaqal.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import szaqal.forkjoin.enums.StringItemType;
import szaqal.forkjoin.formatters.ItemFormatter;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
public class GenerateItemTask extends RecursiveTask<List<String>> {

	private static final Logger LOG = LoggerFactory.getLogger(GenerateItemTask.class);
	
	private static final long serialVersionUID = 8933537008111986053L;

	private int quantity;

	private StringItemType itemType;
	
	private ItemFormatter<String> formatter;
	
	private GenerateItemTask() {
		super();
	}

	public GenerateItemTask(int quantity, StringItemType itemType, ItemFormatter<String> formatter) {
		this();
		this.quantity = quantity;
		this.itemType = itemType;
		this.formatter = formatter;
	}
	
	@SuppressWarnings("unchecked")
	public GenerateItemTask(int quantity, StringItemType itemType) {
		this();
		this.quantity = quantity;
		this.itemType = itemType;
		try {
			this.formatter = (ItemFormatter<String>) ItemFormatter.TYPES.PLAIN.getClazz().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<String> compute() {
		LOG.info(String.format("Generating %s  items", quantity));
		List<String> result = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			result.add((itemType.generateItem(formatter)));
		}
		LOG.info("Task Done");
		return result;
	}

}
