package szaq.lcs;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * This is where we'll store solution candidates
 * 
 * @author malczyk
 *
 */
@Slf4j
public class RulePopulation {

	private int size;
	
	private Set<Rule> rules = new HashSet<>();

	/**
	 * Creates initial rule population
	 * 
	 * @param size
	 *            rule population size
	 */
	public RulePopulation(int size) {
		this.size = size;
	}
	
	public Set<Rule> match(Rule rule) {
		return rules.stream().filter(x->x.getCondition().matches(rule.getCondition())).collect(Collectors.toSet());
	}
	
	public void put(final Rule rule) {
		if(rules.size() == size) {
			throw new UnsupportedOperationException("Rule to big");
		}
		rules.add(rule);
		log.info("{} added -> size {}", rule.toString(), rules.size());
	}
}
