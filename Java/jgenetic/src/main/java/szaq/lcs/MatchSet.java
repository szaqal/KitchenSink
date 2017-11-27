package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Matching ruleset.
 * 
 * @author malczyk
 *
 */
public class MatchSet  implements Iterable<Rule> {
	
	private Set<Rule> matchSet = new HashSet<>();
	

	@Override
	public Iterator<Rule> iterator() {
		return matchSet.iterator();
	}

}
