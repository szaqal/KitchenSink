package szaq.lcs.api;

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
	TRUE("1"), FALSE("0"), UNKNOWN("?");

	private String value;

	WildcardGene(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static WildcardGene randomWithWildcard(Random random) {
		return WildcardGene.values()[random.nextInt(3)];
	}
	
	public static WildcardGene randomWithoutWildcard(Random random) {
		return WildcardGene.values()[random.nextInt(2)];
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
	
	static ISeq<EnumGene<WildcardGene>> seqCustom(final IntRange lengthRange, Supplier<WildcardGene> geneValue) {
		final Random r = RandomRegistry.getRandom();

		return MSeq.<WildcardGene>ofLength(random.nextInt(lengthRange, r)).fill(() -> randomWithWildcard(r))
				.map(x->EnumGene.of(geneValue.get())).toISeq();
	}
	
}