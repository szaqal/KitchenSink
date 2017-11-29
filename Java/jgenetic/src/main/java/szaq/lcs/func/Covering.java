package szaq.lcs.func;

import java.util.UUID;
import java.util.function.Function;

import szaq.lc.ga.api.IWildcardChromosome;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Parameters;

/**
 * Covering initializes a rule by generalizing an instance. 0 2 1 2 0 ~ 1 => 0 #
 * 1 2 # ~ 1
 *
 * @author malczyk
 *
 */
public class Covering implements Function<Classifier, Classifier> {

	@Override
	public Classifier apply(final Classifier generalizedRule) {
		final IWildcardChromosome condition = generalizedRule.getCondition();

		//@formatter:off
		return new Classifier(
				UUID.randomUUID().toString(),
				condition.generalize(),
				generalizedRule.getAction(),
				Parameters.init()
		);
		//@formatter:on
	}

}
