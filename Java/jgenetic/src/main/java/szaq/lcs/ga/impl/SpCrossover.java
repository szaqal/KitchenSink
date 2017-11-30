package szaq.lcs.ga.impl;

import io.jenetics.EnumGene;
import io.jenetics.SinglePointCrossover;
import io.jenetics.util.MSeq;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import szaq.lcs.ga.LcsObjects;
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
		final MSeq<EnumGene<WildcardGene>> that = copyChromosomes(parent1);
		final MSeq<EnumGene<WildcardGene>> other = copyChromosomes(parent2);

		crossover(that, other);

		final WildcardGene[] offspringChromosome1 = asArray(that);
		final WildcardGene[] offspringChromosome2 = asArray(other);

		final Classifier offspring1 = LcsObjects.anyClassifier(offspringChromosome1);
		final Classifier offspring2 = LcsObjects.anyClassifier(offspringChromosome2);

		return Tuple.of(offspring1, offspring2);
	}

	private WildcardGene[] asArray(final MSeq<EnumGene<WildcardGene>> seq) {
		return seq.map(x -> x.getAllele()).toArray(new WildcardGene[seq.size()]);
	}

	private MSeq<EnumGene<WildcardGene>> copyChromosomes(final Classifier classifier) {
		return classifier.getCondition().toSeq().copy();
	}

}
