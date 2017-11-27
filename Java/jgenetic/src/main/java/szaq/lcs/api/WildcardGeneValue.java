package szaq.lcs.api;

import java.util.Random;

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
public enum WildcardGeneValue {
	TRUE("1"),
	FALSE("0"),
	UNKNOWN("?");
	
	private String value;
	
	WildcardGeneValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static WildcardGeneValue randomValue(Random random) {
		return WildcardGeneValue.values()[random.nextInt(WildcardGeneValue.values().length)];
	}
	
	
	static ISeq<EnumGene<WildcardGeneValue>> seq(
			final IntRange lengthRange
		) {
			final Random r = RandomRegistry.getRandom();

			
			
			return MSeq.<WildcardGeneValue>ofLength(random.nextInt(lengthRange, r))
				.fill(() -> randomValue(r))
				.map(x->EnumGene.of(x))
				.toISeq();
		}
}