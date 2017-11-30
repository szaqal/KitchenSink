package szaq.lcs.ga;

import java.util.Random;
import java.util.function.Supplier;

import io.jenetics.EnumGene;
import io.jenetics.internal.math.random;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;
import io.jenetics.util.MSeq;
import io.jenetics.util.RandomRegistry;

/**
 * @author malczyk
 *
 */
public enum WildcardGene {

	TRUE("1", false), FALSE("0", false), WILDCARD("?", true);

	private String representation;

	private boolean matchesAnyhing;

	WildcardGene(final String respresentation, final boolean matchesAnyhing) {
		this.representation = respresentation;
		this.matchesAnyhing = matchesAnyhing;
	}

	public String getValue() {
		return representation;
	}

	public static WildcardGene randomWithWildcard(final Random random) {
		return WildcardGene.values()[random.nextInt(3)];
	}

	public static WildcardGene randomWithoutWildcard(final Random random) {
		return WildcardGene.values()[random.nextInt(2)];
	}

	public boolean matches(final WildcardGene that) {
		if (matchesAnyhing || that.matchesAnyhing) {
			return true;
		}
		return this.equals(that);
	}

	static ISeq<EnumGene<WildcardGene>> seqWithoutWildcard(final IntRange lengthRange) {

		final Random r = RandomRegistry.getRandom();

		return MSeq.<WildcardGene>ofLength(random.nextInt(lengthRange, r)).fill(() -> randomWithoutWildcard(r))
				.map(x -> EnumGene.of(x)).toISeq();
	}

	static ISeq<EnumGene<WildcardGene>> seqWithWildcard(final IntRange lengthRange) {

		final Random r = RandomRegistry.getRandom();

		return MSeq.<WildcardGene>ofLength(random.nextInt(lengthRange, r)).fill(() -> randomWithWildcard(r))
				.map(x -> EnumGene.of(x)).toISeq();
	}

	static ISeq<EnumGene<WildcardGene>> seqCustom(final IntRange lengthRange, final Supplier<WildcardGene> geneValue) {
		final Random r = RandomRegistry.getRandom();

		return MSeq.<WildcardGene>ofLength(random.nextInt(lengthRange, r)).fill(() -> randomWithWildcard(r))
				.map(x -> EnumGene.of(geneValue.get())).toISeq();
	}

}