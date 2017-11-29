package szaq.lcs.functional;

import szaq.lcs.model.Classifier;

@FunctionalInterface
public interface ActionMatcher {

	boolean matched(Classifier ruleA, Classifier ruleB);
}
