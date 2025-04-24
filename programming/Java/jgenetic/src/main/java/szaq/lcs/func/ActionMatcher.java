package szaq.lcs.func;

import szaq.lcs.model.Classifier;

/**
 * @author malczyk
 *
 */
@FunctionalInterface
public interface ActionMatcher {

	/**
	 * Verifies is action are matched regardless of means of doing that.
	 *
	 * @param conditionA
	 *            conditionA
	 * @param conditionB
	 *            conditionB
	 * @return true/false
	 */
	boolean matched(Classifier conditionA, Classifier conditionB);
}
