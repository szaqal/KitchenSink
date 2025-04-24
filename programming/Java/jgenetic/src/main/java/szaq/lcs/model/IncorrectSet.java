package szaq.lcs.model;

import szaq.lcs.BaseMatchingSet;

/**
 * @author malczyk
 *
 */
public class IncorrectSet extends BaseMatchingSet {

	public IncorrectSet(final Classifier evaluatedRule, final MatchSet matchSet) {
		super(evaluatedRule, matchSet, (x, y) -> x.getAction() != y.getAction());
	}
}
