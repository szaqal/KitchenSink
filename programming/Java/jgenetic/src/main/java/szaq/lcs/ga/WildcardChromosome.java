package szaq.lcs.ga;

import static java.util.stream.Collectors.joining;
import static szaq.lcs.ga.WildcardGene.seqWithWildcard;

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

	/** {@inheritDoc} */
	@Override
	public int chromosomeLength() {
		return toSeq().size();
	}

	/** {@inheritDoc} */
	@Override
	public WildcardGene[] asArray() {
		return toSeq().map(x -> x.getAllele()).toArray(new WildcardGene[chromosomeLength()]);
	}

}
