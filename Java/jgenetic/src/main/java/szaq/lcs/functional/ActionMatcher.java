package szaq.lcs.functional;

import szaq.lcs.model.Rule;

@FunctionalInterface
public interface ActionMatcher {

	boolean matched(Rule ruleA, Rule ruleB);
}
