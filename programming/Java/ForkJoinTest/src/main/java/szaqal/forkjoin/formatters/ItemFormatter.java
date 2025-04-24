package szaqal.forkjoin.formatters;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public interface ItemFormatter<T> {
	
	enum TYPES {
		PLAIN(PlainFormatter.class),
		CSV(CsvFormatter.class),
		XML(XmlFormatter.class);
		
		private final Class<?> clazz;
		
		TYPES(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Class<?> getClazz() {
			return clazz;
		}
	}
	
	T format(T item);
	
	T format(T[] items);
}
