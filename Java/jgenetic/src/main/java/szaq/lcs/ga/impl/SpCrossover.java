package szaq.lcs.ga.impl;

import io.jenetics.EnumGene;
import io.jenetics.SinglePointCrossover;
import io.jenetics.util.MSeq;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.CrossoverOperator;
import szaq.lcs.model.Classifier;

/**
 * @see {@link io.jenetics.Crossover}
 * @author malczyk
 *
 */
public class SpCrossover extends SinglePointCrossover<EnumGene<WildcardGene>, Double> implements CrossoverOperator {

	@Override
	public Tuple2<Classifier, Classifier> doCrossover(final Classifier parent1, final Classifier parent2) {
		final MSeq<EnumGene<WildcardGene>> that = parent1.getCondition().toSeq().copy();
		final MSeq<EnumGene<WildcardGene>> other = parent2.getCondition().toSeq().copy();

		crossover(that, other);

		final WildcardGene[] offspringChromosome1 = that.toArray(new WildcardGene[that.size()]);
		final WildcardGene[] offspringChromosome2 = other.toArray(new WildcardGene[other.size()]);
		return Tuple.of(parent1, parent2);
	}

}
