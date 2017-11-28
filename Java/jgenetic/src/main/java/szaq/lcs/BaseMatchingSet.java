package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import szaq.jgenetic.functional.ActionMatcher;

public abstract class BaseMatchingSet implements Iterable<Rule> {

	private Rule evaluatedRule;

	private Set<Rule> itemSet = new HashSet<>();

	protected BaseMatchingSet(final Rule evaluatedRule, final MatchSet matchSet, final ActionMatcher actionMatcher) {
		Objects.requireNonNull(evaluatedRule);
		this.evaluatedRule = evaluatedRule;
		for (Rule rule : matchSet) {
			if (actionMatcher.matched(rule, evaluatedRule)) {
				itemSet.add(rule);
			}
		}
	}
	
	public boolean isEmpty() {
		return itemSet.isEmpty();
	}

	public void add(Rule rule) {
		itemSet.add(rule);
	}

	@Override
	public Iterator<Rule> iterator() {
		return itemSet.iterator();
	}
	
	protected Rule getEvaluatedRule() {
		return evaluatedRule;
	}
	
	public Set<Rule> getItemSet() {
		return itemSet;
	}
	
	@Override
	public String toString() {
		List<Rule> vals = Lists.newArrayList(evaluatedRule);
		vals.addAll(itemSet);
		return vals.stream().map(x->String.format("%s:%s", x.getCondition().toCanonicalString(), x.getAction())).collect(Collectors.joining(","));
	}
}
