package szaq.lcs.api;

import static java.util.stream.Collectors.joining;
import static szaq.lcs.api.WildcardGene.seqWithWildcard;

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
import lombok.extern.slf4j.Slf4j;

/**
 * @author malczyk
 *
 */
@Slf4j
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
		ISeq<EnumGene<WildcardGene>> iSeq = MSeq.<WildcardGene>ofLength(wildcardGene.length)
				.setAll(wildcardGene)
				.map(x -> EnumGene.of(x)).toISeq();
		return new WildcardChromosome(iSeq);
	}

	public WildcardChromosome generalize() {
		Random rand = new Random();
		WildcardChromosome allWildcard = allWildcard();
		int length = allWildcard.length();

		// Covering adds #’s to a new rule with probability of generalization 0.33 - 0.5
		// (typically)
		int lower = Math.round((float) 0.33 * length);
		int upper = Math.round((float) 0.5 * length);
		MSeq<EnumGene<WildcardGene>> seq = allWildcard.toSeq().asMSeq();

		int toChange = io.jenetics.internal.math.random.nextInt(IntRange.of(lower, upper), rand);
		
		Set<Integer> positionsToChange = new HashSet<>();
		while(positionsToChange.size()<toChange) {
			int nextInt = io.jenetics.internal.math.random.nextInt(0, length, rand);
			if(positionsToChange.add(nextInt)) {
				seq.set(nextInt, toSeq().get(nextInt));
			}
			
		}
		
		return new WildcardChromosome(seq.asISeq());
	}

	/**
	 * For testing only
	 */
	public static WildcardChromosome randomTrue() {
		return training(() -> WildcardGene.TRUE);
	}

	/**
	 * For testing only
	 */
	public static WildcardChromosome randomFalse() {
		return training(() -> WildcardGene.FALSE);
	}

	public static WildcardChromosome allWildcard() {
		return new WildcardChromosome(WildcardGene.seqCustom(IntRange.of(DEFAULT_LENGTH), () -> WildcardGene.WILDCARD));
	}

	private static WildcardChromosome training(Supplier<WildcardGene> gene) {
		IntRange length = IntRange.of(DEFAULT_LENGTH / 2);
		return new WildcardChromosome(
				WildcardGene.seqWithoutWildcard(length).append(WildcardGene.seqCustom(length, gene)));
	}

	public boolean matches(WildcardChromosome that) {
		WildcardGene[] thisChromosome = asArray(this.toSeq());
		WildcardGene[] thatChromosome = asArray(that.toSeq());

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

	private WildcardGene[] asArray(ISeq<EnumGene<WildcardGene>> input) {
		return input.map(x -> x.getAllele()).toArray(new WildcardGene[input.size()]);
	}

	public long countWildcards() {
		Long count = toSeq().stream().filter(x->WildcardGene.WILDCARD.equals(x.getAllele())).collect(Collectors.counting());
		return count;
	}

}
