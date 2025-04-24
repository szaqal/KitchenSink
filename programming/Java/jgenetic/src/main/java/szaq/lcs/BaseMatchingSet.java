package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import szaq.lcs.func.ActionMatcher;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.MatchSet;

public abstract class BaseMatchingSet implements Iterable<Classifier> {

	private final Classifier evaluatedRule;

	private final Set<Classifier> itemSet = new HashSet<>();

	protected BaseMatchingSet(final Classifier evaluatedRule, final MatchSet matchSet,
			final ActionMatcher actionMatcher) {

		Objects.requireNonNull(evaluatedRule);
		this.evaluatedRule = evaluatedRule;
		for (final Classifier rule : matchSet) {
			if (actionMatcher.matched(rule, evaluatedRule)) {
				itemSet.add(rule);
			}
		}
	}

	public boolean isEmpty() {
		return itemSet.isEmpty();
	}

	public void add(final Classifier rule) {
		itemSet.add(rule);
	}

	@Override
	public Iterator<Classifier> iterator() {
		return itemSet.iterator();
	}

	protected Classifier getEvaluatedRule() {
		return evaluatedRule;
	}

	public Set<Classifier> getItemSet() {
		return itemSet;
	}

	@Override
	public String toString() {
		final List<Classifier> vals = Lists.newArrayList(evaluatedRule);
		vals.addAll(itemSet);
		return vals.stream().map(x -> String.format("%s:%s", x.getCondition().toCanonicalString(), x.getAction()))
				.collect(Collectors.joining(","));
	}
}
