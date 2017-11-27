package szaq.lcs;

import java.util.UUID;
import java.util.function.Function;

import szaq.lcs.api.WildcardChromosome;

/**
 * Covering initializes a rule by generalizing an instance. 0 2 1 2 0 ~ 1 => 0 #
 * 1 2 # ~ 1
 * 
 * @author malczyk
 *
 */
public class Covering implements Function<Rule, Rule> {

	@Override
	public Rule apply(Rule generalizedRule) {
		WildcardChromosome condition = generalizedRule.getCondition();
		return new Rule(UUID.randomUUID().toString(), condition.generalize(), generalizedRule.getAction());
	}

}
