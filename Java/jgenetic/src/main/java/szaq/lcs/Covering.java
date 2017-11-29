package szaq.lcs;

import java.util.UUID;
import java.util.function.Function;

import szaq.lc.ga.WildcardChromosome;
import szaq.lcs.model.Parameters;
import szaq.lcs.model.Classifier;

/**
 * Covering initializes a rule by generalizing an instance. 0 2 1 2 0 ~ 1 => 0 #
 * 1 2 # ~ 1
 * 
 * @author malczyk
 *
 */
public class Covering implements Function<Classifier, Classifier> {

	@Override
	public Classifier apply(Classifier generalizedRule) {
		WildcardChromosome condition = generalizedRule.getCondition();
		return new Classifier(UUID.randomUUID().toString(), condition.generalize(), generalizedRule.getAction(),Parameters.init());
	}

}
