package szaq.lc.ga;

import static java.util.stream.Collectors.joining;
import static szaq.lc.ga.WildcardGene.seqWithWildcard;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import io.jenetics.AbstractChromosome;
import io.jenetics.EnumGene;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;
import io.jenetics.util.MSeq;
import szaq.lc.ga.api.IWildcardChromosome;

/**
 * @author malczyk
 *
 */
public final class WildcardChromosome extends AbstractChromosome<EnumGene<WildcardGene>>
		implements IWildcardChromosome {

	/**
	 * Default chromosome length.
	 */
	private static final int DEFAULT_LENGTH = 8;

	private static final long serialVersionUID = 6027715032396038105L;

	protected WildcardChromosome(final ISeq<? extends EnumGene<WildcardGene>> genes) {
		super(genes);
	}

	/**
	 * Returns formatted chromosome value.
	 *
	 * @return string representation
	 */
	public String toCanonicalString() {
		return toSeq().stream().map(g -> g.getAllele().getValue()).collect(joining());
	}

	/** {@inheritDoc} */
	@Override
	public WildcardChromosome newInstance(final ISeq<EnumGene<WildcardGene>> genes) {
		return new WildcardChromosome(genes);
	}

	/** {@inheritDoc} */
	@Override
	public WildcardChromosome newInstance() {
		return new WildcardChromosome(seqWithWildcard(IntRange.of(DEFAULT_LENGTH)));
	}

	public static WildcardChromosome random() {
		return new WildcardChromosome(seqWithWildcard(IntRange.of(DEFAULT_LENGTH)));
	}

	/**
	 *
	 * @param wildcardGene
	 * @return
	 */
	public static WildcardChromosome of(final WildcardGene[] wildcardGene) {
		//@formatter:off
		final ISeq<EnumGene<WildcardGene>> iSeq = MSeq.<WildcardGene>ofLength(wildcardGene.length)
				.setAll(wildcardGene)
				.map(x -> EnumGene.of(x))
				.toISeq();
		//@formatter:on
		return new WildcardChromosome(iSeq);
	}

	/** {@inheritDoc} */
	@Override
	public WildcardChromosome generalize() {
		// TODO: generalization of chromosomes with wildcards
		final Random rand = new Random();
		final WildcardChromosome allWildcard = allWildcard();
		final int length = allWildcard.length();

		// Covering adds #’s to a new rule with probability of generalization 0.33 - 0.5
		// (typically)
		final int lower = Math.round((float) 0.33 * length);
		final int upper = Math.round((float) 0.5 * length);
		final MSeq<EnumGene<WildcardGene>> seq = allWildcard.toSeq().asMSeq();

		final int toChange = io.jenetics.internal.math.random.nextInt(IntRange.of(lower, upper), rand);

		final Set<Integer> positionsToChange = new HashSet<>();
		while (positionsToChange.size() < toChange) {
			final int nextInt = io.jenetics.internal.math.random.nextInt(0, length, rand);
			if (positionsToChange.add(nextInt)) {
				seq.set(nextInt, toSeq().get(nextInt));
			}

		}

		return new WildcardChromosome(seq.asISeq());
	}

	public static WildcardChromosome allWildcard() {
		return new WildcardChromosome(WildcardGene.seqCustom(IntRange.of(DEFAULT_LENGTH), () -> WildcardGene.WILDCARD));
	}

	/** {@inheritDoc} */
	@Override
	public boolean matches(final IWildcardChromosome that) {
		final WildcardGene[] thisChromosome = asArray(this.toSeq());
		final WildcardGene[] thatChromosome = asArray(that.toSeq());

		if (thisChromosome.length != thatChromosome.length) {
			return false;
		}

		for (int i = 0; i < thisChromosome.length; i++) {
			if (!thisChromosome[i].matches(thatChromosome[i])) {
				return false;
			}
		}

		return true;
	}

	/** {@inheritDoc} */
	@Override
	public long countWildcards() {
		//@formatter:off
		return toSeq()
				.stream()
				.filter(x -> WildcardGene.WILDCARD.equals(x.getAllele()))
				.collect(Collectors.counting());
		//@formatter:on
	}

	/**
	 * Returns from this chromosome all genes as array
	 *
	 * @param input
	 *            sequence of genes
	 * @return array of genes
	 */
	private WildcardGene[] asArray(final ISeq<EnumGene<WildcardGene>> input) {
		return input.map(x -> x.getAllele()).toArray(new WildcardGene[input.size()]);
	}

	// ---------- utility testing methods

	/**
	 * Creates wildcards chromosome that half is random and second half is true
	 *
	 * @return {@link WildcardChromosome}
	 */
	public static WildcardChromosome randomTrue() {
		return training(() -> WildcardGene.TRUE);
	}

	/**
	 * Creates wildcards chromosome that half is random and second half is false
	 *
	 * @return {@link WildcardChromosome}
	 */
	public static WildcardChromosome randomFalse() {
		return training(() -> WildcardGene.FALSE);
	}

	/**
	 * Creates chromosome that is build from random part and predefined part
	 * provided by supplied
	 *
	 * @param gene
	 *            fixed part value supplied
	 * @return {@link WildcardChromosome}
	 */
	private static WildcardChromosome training(final Supplier<WildcardGene> gene) {
		final IntRange length = IntRange.of(DEFAULT_LENGTH / 2);
		return new WildcardChromosome(
				WildcardGene.seqWithoutWildcard(length).append(WildcardGene.seqCustom(length, gene)));
	}

}
