package szaqal.forkjoin.formatters;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public class XmlFormatter implements ItemFormatter<String> {

	@Override
	public String format(String item) {
		return String.format("<item>%s</item>", item);
	}

	@Override
	public String format(String[] items) {
		StringBuffer element = new StringBuffer("<item>");
		for(String item: items) {
			element.append(String.format("<arg>%s</arg>", item));
		}
		element.append("</item>");
		return element.toString();
	}

}
