package szaq.lcs.ga.impl;

import java.util.Random;

import io.jenetics.Chromosome;
import io.jenetics.EnumGene;
import io.jenetics.MutatorResult;
import io.jenetics.SwapMutator;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;
import szaq.lcs.ga.api.MutationOperator;
import szaq.lcs.model.Classifier;

/**
 * Created by malczyk on 29.11.17.
 */
public class SwapMutation extends SwapMutator<EnumGene<WildcardGene>, Double> implements MutationOperator {

	private final Random random = new Random();

	public double mutationPropability;

	public SwapMutation(final double mutationPropability) {
		this.mutationPropability = mutationPropability;
	}

	@Override
	public Classifier mutate(final Classifier classifier) {
		final MutatorResult<Chromosome<EnumGene<WildcardGene>>> mutationResult = mutate(classifier.getCondition(),
				mutationPropability, random);

		classifier.setCondition((IWildcardChromosome) mutationResult.getResult());
		return classifier;
	}
}
