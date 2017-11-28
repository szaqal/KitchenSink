package szaq.lcs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;

/**
 * Matching ruleset.
 * 
 * @author malczyk
 *
 */
@Slf4j
public class MatchSet  implements Iterable<Rule> {
	
	private Set<Rule> itemSet;
	
	public MatchSet(Set<Rule> rulesMatched) {
		this.itemSet = rulesMatched;
	}

	@Override
	public Iterator<Rule> iterator() {
		return itemSet.iterator();
	}
	
	public void addAll(Set<Rule> matched ) {
		itemSet.addAll(matched);
		log.debug("Match size {}",itemSet.size());
	}
	
	@Override
	public String toString() {
		List<String> collect = itemSet.stream().map(x->x.getCondition().toCanonicalString()+ ":"+x.getAction()).collect(Collectors.toList());
		return Joiner.on("\n").join(collect);
	}
	
	public Set<Rule> getItemSet() {
		return itemSet;
	}
}
