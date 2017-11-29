package szaq.lcs.ga;

import static java.util.stream.Collectors.joining;
import static szaq.lcs.ga.WildcardGene.seqWithWildcard;

import java.util.function.Supplier;
import java.util.stream.Collectors;

import io.jenetics.AbstractChromosome;
import io.jenetics.EnumGene;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;
import io.jenetics.util.MSeq;
import szaq.lcs.func.ChromosomeMatched;
import szaq.lcs.func.Generalizer;
import szaq.lcs.ga.api.IWildcardChromosome;

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

	/** {@inheritDoc} */
	@Override
	public String toCanonicalString() {
		return toSeq().stream().map(g -> g.getAllele().getValue()).collect(joining());
	}

	/** {@inheritDoc} */
	@Override
	public IWildcardChromosome newInstance(final ISeq<EnumGene<WildcardGene>> genes) {
		return new WildcardChromosome(genes);
	}

	/** {@inheritDoc} */
	@Override
	public IWildcardChromosome newInstance() {
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
	public IWildcardChromosome generalize() {
		return new Generalizer().apply(this);
	}

	/** {@inheritDoc} */
	@Override
	public boolean matches(final IWildcardChromosome that) {
		return new ChromosomeMatched().test(this, that);
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

	// ---------- utility testing methods

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

	/**
	 * Creates chromosome that is build from random part and predefined part
	 * provided by supplied
	 *
	 * @param gene
	 *            fixed part value supplied
	 * @return {@link WildcardChromosome}
	 */
	private static IWildcardChromosome training(final Supplier<WildcardGene> gene) {
		final IntRange length = IntRange.of(DEFAULT_LENGTH / 2);
		return new WildcardChromosome(
				WildcardGene.seqWithoutWildcard(length).append(WildcardGene.seqCustom(length, gene)));
	}

}
