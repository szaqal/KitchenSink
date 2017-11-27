package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IncorrectSet implements Iterable<Rule> {
	
	private Set<Rule> inCorrectSet = new HashSet<>();

	@Override
	public Iterator<Rule> iterator() {
		return inCorrectSet.iterator();
	}
	public void add(Rule rule) {
		inCorrectSet.add(rule);
		log.debug("Added incorrect {} {}", rule, inCorrectSet.size());
	}

}
