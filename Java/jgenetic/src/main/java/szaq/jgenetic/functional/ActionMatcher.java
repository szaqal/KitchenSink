package szaq.jgenetic.functional;

import szaq.lcs.Rule;

@FunctionalInterface
public interface ActionMatcher {

	boolean matched(Rule ruleA, Rule ruleB);
}
