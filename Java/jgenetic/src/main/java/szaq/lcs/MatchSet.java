package szaq.lcs;

import java.util.HashSet;
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
	
	private Set<Rule> matchSet = new HashSet<>();
	

	@Override
	public Iterator<Rule> iterator() {
		return matchSet.iterator();
	}
	
	public void addAll(Set<Rule> matched ) {
		matchSet.addAll(matched);
		log.info("Match size {}",matchSet.size());
	}
	
	@Override
	public String toString() {
		List<String> collect = matchSet.stream().map(x->x.getCondition().toCanonicalString()+ ":"+x.getAction()).collect(Collectors.toList());
		return Joiner.on("\n").join(collect);
	}
}
