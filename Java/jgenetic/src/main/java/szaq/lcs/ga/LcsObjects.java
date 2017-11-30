package szaq.lcs.ga;

import java.util.function.Supplier;

import io.jenetics.util.IntRange;
import szaq.lcs.ga.api.IWildcardChromosome;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Parameters;

/**
 * Utility class for creation various kinds of chromosomes
 *
 * @author malczyk
 *
 */
public final class LcsObjects {

	/**
	 * Creates wildcards chromosome that half is random and second half is true
	 *
	 * @return {@link WildcardChromosome}
	 */
	public static IWildcardChromosome randomTrue() {
		return training(() -> WildcardGene.TRUE);
	}

	/**
	 * Creates wildcards chromosome that half is random and second half is false
	 *
	 * @return {@link WildcardChromosome}
	 */
	public static IWildcardChromosome randomFalse() {
		return training(() -> WildcardGene.FALSE);
	}

	public static IWildcardChromosome random() {
		return new WildcardChromosome(WildcardGene.seqWithWildcard(IntRange.of(IWildcardChromosome.DEFAULT_LENGTH)));
	}

	/**
	 * Creates chromosome that is build from random part and predefined part
	 * provided by supplied
	 *
	 * @param gene
	 *            fixed part value supplied
	 * @return {@link WildcardChromosome}
	 */
	private static IWildcardChromosome training(final Supplier<WildcardGene> gene) {
		final IntRange length = IntRange.of(IWildcardChromosome.DEFAULT_LENGTH / 2);
		return new WildcardChromosome(
				WildcardGene.seqWithoutWildcard(length).append(WildcardGene.seqCustom(length, gene)));
	}

	public static Classifier anyClassifier(final String name, final WildcardGene... genes) {
		return new Classifier(name, anyChromosome(genes), 0, Parameters.init());
	}

	public static IWildcardChromosome anyChromosome(final WildcardGene... genes) {
		return WildcardChromosome.of(genes);
	}

}
