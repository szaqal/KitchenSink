package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Matching and 
 * @author malczyk
 *
 */
public class CorrectSet implements Iterable<Rule> {

	private Set<Rule> correctSet = new HashSet<>();
	
	@Override
	public Iterator<Rule> iterator() {
		return correctSet.iterator();
	}

}
