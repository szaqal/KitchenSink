package szaqal.forkjoin.formatters;

import com.google.common.base.Joiner;


/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class CsvFormatter implements ItemFormatter<String> {

	@Override
	public String format(String item) {
		return "\""+item+"\"";
	}

	@Override
	public String format(String[] items) {
		return Joiner.on(",").join(items);
	}

}
