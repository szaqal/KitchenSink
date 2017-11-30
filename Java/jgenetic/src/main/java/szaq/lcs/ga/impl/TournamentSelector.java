package szaq.lcs.ga.impl;

import java.util.function.Function;

import io.jenetics.EnumGene;
import io.jenetics.Optimize;
import io.jenetics.Phenotype;
import io.jenetics.util.ISeq;
import io.vavr.Tuple2;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.SelectionOperator;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Population;

/**
 * Created by malczyk on 29.11.17.
 */
public class TournamentSelector extends io.jenetics.TournamentSelector<EnumGene<WildcardGene>, Double>
		implements SelectionOperator {

	@Override
	public Tuple2<Classifier, Classifier> select(final Population rulePopulation) {
		// ISeq<Phenotype<G, C>>

		final ISeq<Phenotype<EnumGene<WildcardGene>, Double>> select = select(null, 2, Optimize.MAXIMUM);
		return null;
	}

	private class ToPhenotype implements Function<Classifier, Phenotype<EnumGene<WildcardGene>, Double>> {

		private final int currentGeneration;

		public ToPhenotype(final int generation) {
			this.currentGeneration = generation;
		}

		@Override
		public Phenotype<EnumGene<WildcardGene>, Double> apply(final Classifier classifier) {
			return Phenotype.of(null, currentGeneration, null);
		}

	}

}
