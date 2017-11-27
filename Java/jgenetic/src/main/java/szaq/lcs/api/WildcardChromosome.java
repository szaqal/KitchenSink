package szaq.lcs.api;

import static java.util.stream.Collectors.joining;
import static szaq.lcs.api.WildcardGene.seqWithWildcard;

import java.util.function.Supplier;

import io.jenetics.AbstractChromosome;
import io.jenetics.EnumGene;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;
import io.jenetics.util.MSeq;

/**
 * @author malczyk
 *
 */
public final class WildcardChromosome extends AbstractChromosome<EnumGene<WildcardGene>> {

	private static final int DEFAULT_LENGTH = 8;

	private static final long serialVersionUID = 6027715032396038105L;

	protected WildcardChromosome(ISeq<? extends EnumGene<WildcardGene>> genes) {
		super(genes);
	}

	public String toCanonicalString() {
		return toSeq().stream().map(g -> g.getAllele().getValue()).collect(joining());
	}

	@Override
	public WildcardChromosome newInstance(ISeq<EnumGene<WildcardGene>> genes) {
		return new WildcardChromosome(genes);
	}

	@Override
	public WildcardChromosome newInstance() {
		return new WildcardChromosome(seqWithWildcard(IntRange.of(DEFAULT_LENGTH)));
	}

	public static WildcardChromosome random() {
		return new WildcardChromosome(seqWithWildcard(IntRange.of(DEFAULT_LENGTH)));
	}
	
	public static WildcardChromosome of(WildcardGene[] wildcardGene) {
		ISeq<EnumGene<WildcardGene>> iSeq = MSeq.<WildcardGene>ofLength(DEFAULT_LENGTH).setAll(wildcardGene).fill(() -> wildcardGene[1])
				.map(x -> EnumGene.of(x)).toISeq();
		return new WildcardChromosome(iSeq);
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
		return testing(() -> WildcardGene.FALSE);
	}

	private static WildcardChromosome testing(Supplier<WildcardGene> gene) {
		IntRange length = IntRange.of(DEFAULT_LENGTH / 2);
		return new WildcardChromosome(
				WildcardGene.seqWithoutWildcard(length).append(WildcardGene.seqCustom(length, gene)));
	}

	public boolean matches(WildcardChromosome that) {
		WildcardGene[] thisChromosome = asArray(this.toSeq());
		WildcardGene[] thatChromosome = asArray(that.toSeq());
		
		if(thisChromosome.length != thatChromosome.length) {
			return false;
		}
		
		for(int i=0;i<thisChromosome.length;i++) {
			if(!thisChromosome[i].matches(thatChromosome[i])) {
				return false;
			}
		}
		
		return true;
	}
	

	private WildcardGene[] asArray(ISeq<EnumGene<WildcardGene>> input) {
		return input.map(x -> x.getAllele()).toArray(new WildcardGene[input.size()]);
	}

}
