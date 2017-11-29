package szaq.lc.ga.impl;

import java.util.Random;

import io.jenetics.Chromosome;
import io.jenetics.EnumGene;
import io.jenetics.MutatorResult;
import io.jenetics.SwapMutator;
import szaq.lc.ga.WildcardGene;
import szaq.lc.ga.api.MutationOperator;
import szaq.lcs.model.Classifier;

/**
 * Created by malczyk on 29.11.17.
 */
public class SwapMutation extends SwapMutator<EnumGene<WildcardGene>, Double> implements MutationOperator {

	private final Random random = new Random();

	public double mutationPropability;

	@Override
	public Classifier mutate(final Classifier classifier) {
		final MutatorResult<Chromosome<EnumGene<WildcardGene>>> mutationReult = mutate(classifier.getCondition(), 0.55,
				random);
		return null;
	}
}
