package szaqal.forkjoin.generators;

import szaqal.forkjoin.formatters.ItemFormatter;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public interface ItemGenerator<T> {

	T generateItem(ItemFormatter<T> formatter);
	
}
