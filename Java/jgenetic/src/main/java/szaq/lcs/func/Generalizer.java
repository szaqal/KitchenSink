package szaq.lcs.func;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import io.jenetics.EnumGene;
import io.jenetics.util.IntRange;
import io.jenetics.util.MSeq;
import szaq.lc.ga.WildcardChromosome;
import szaq.lc.ga.WildcardGene;
import szaq.lc.ga.api.IWildcardChromosome;

/**
 * Chromosome generalizing function
 *
 * @author malczyk
 *
 */
public class Generalizer implements Function<IWildcardChromosome, IWildcardChromosome> {

	private final Random rand = new Random();

	@Override
	public IWildcardChromosome apply(final IWildcardChromosome specialized) {
		// TODO: generalization of chromosomes with wildcards

		final int size = specialized.toSeq().size();

		final WildcardChromosome allWildcard = allWildcard(size);

		// Covering adds #’s to a new rule with probability of generalization 0.33 - 0.5
		// (typically)
		final int lower = Math.round((float) 0.33 * size);
		final int upper = Math.round((float) 0.5 * size);
		final MSeq<EnumGene<WildcardGene>> seq = allWildcard.toSeq().asMSeq();

		final int toChange = io.jenetics.internal.math.random.nextInt(IntRange.of(lower, upper), rand);

		final Set<Integer> positionsToChange = new HashSet<>();
		while (positionsToChange.size() < toChange) {
			final int nextInt = io.jenetics.internal.math.random.nextInt(0, size, rand);
			if (positionsToChange.add(nextInt)) {
				seq.set(nextInt, specialized.toSeq().get(nextInt));
			}

		}
		final WildcardGene[] arr = new WildcardGene[size];
		final WildcardGene[] array = seq.map(x -> x.getAllele()).toArray(arr);
		return WildcardChromosome.of(array);
	}

	public static WildcardChromosome allWildcard(final int size) {
		final WildcardGene[] genes = new WildcardGene[size];
		Arrays.fill(genes, WildcardGene.WILDCARD);
		return WildcardChromosome.of(genes);
	}
}
