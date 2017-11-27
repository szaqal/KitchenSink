package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * Matching and with correct classes
 * @author malczyk
 *
 */
@Slf4j
public class CorrectSet implements Iterable<Rule> {

	private Set<Rule> correctSet = new HashSet<>();
	
	@Override
	public Iterator<Rule> iterator() {
		return correctSet.iterator();
	}
	
	public void add(Rule rule) {
		correctSet.add(rule);
		log.debug("Added correct {} {}", rule, correctSet.size());
	}

}
