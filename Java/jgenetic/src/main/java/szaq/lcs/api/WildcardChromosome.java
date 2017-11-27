package szaq.lcs.api;

import static java.util.stream.Collectors.joining;

import java.util.function.Supplier;

import io.jenetics.AbstractChromosome;
import io.jenetics.EnumGene;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;

/**
 * @author malczyk
 *
 */
public class WildcardChromosome extends AbstractChromosome<EnumGene<WildcardGene>> {

	protected WildcardChromosome(ISeq<? extends EnumGene<WildcardGene>> genes) {
		super(genes);
	}

	private static final int DEFAULT_LENGTH = 8;

	private static final long serialVersionUID = 6027715032396038105L;

	public String toCanonicalString() {
		return toSeq().stream().map(g -> g.getAllele().getValue()).collect(joining());
	}

	@Override
	public WildcardChromosome newInstance(ISeq<EnumGene<WildcardGene>> genes) {
		return new WildcardChromosome(genes);
	}

	@Override
	public WildcardChromosome newInstance() {
		return new WildcardChromosome(WildcardGene.seqWithWildcard(IntRange.of(DEFAULT_LENGTH)));
	}

	public static WildcardChromosome random() {
		return new WildcardChromosome(WildcardGene.seqWithWildcard(IntRange.of(DEFAULT_LENGTH)));
	}

	/**
	 * For testing only
	 */
	public static WildcardChromosome randomTrue() {
		return testing(() -> WildcardGene.TRUE);
	}

	/**
	 * For testing only
	 */
	public static WildcardChromosome randomFalse() {
		return testing(()-> WildcardGene.FALSE);
	}

	private static WildcardChromosome testing(Supplier<WildcardGene> gene) {
		IntRange length = IntRange.of(DEFAULT_LENGTH / 2);
		ISeq<EnumGene<WildcardGene>> random = WildcardGene.seqWithoutWildcard(length);
		ISeq<EnumGene<WildcardGene>> fixed = WildcardGene.seqCustom(length, gene);
		return new WildcardChromosome(random.append(fixed));
	}

}
