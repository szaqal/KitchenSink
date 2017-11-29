package szaq.lcs.api;

import static szaq.lcs.ga.WildcardGene.FALSE;
import static szaq.lcs.ga.WildcardGene.TRUE;
import static szaq.lcs.ga.WildcardGene.WILDCARD;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import szaq.lcs.ga.WildcardChromosome;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;

public class WildcardChromosomeTest {

	@Test
	public void testCreate() {
		final WildcardChromosome randomFalse = WildcardChromosome.random();
		final String canonicalString = randomFalse.toCanonicalString();
		System.out.println("Create > " + canonicalString);
		Assertions.assertThat(canonicalString.length()).isEqualTo(8);
	}

	@Test
	public void testFalse() {
		final IWildcardChromosome randomFalse = WildcardChromosome.randomFalse();
		final String canonicalString = randomFalse.toCanonicalString();
		System.out.println("False > " + canonicalString);
		Assertions.assertThat(canonicalString.substring(4)).isEqualTo("0000");
	}

	@Test
	public void testTtrue() {
		final IWildcardChromosome randomTrue = WildcardChromosome.randomTrue();
		final String canonicalString = randomTrue.toCanonicalString();
		System.out.println("True > " + canonicalString);
		Assertions.assertThat(canonicalString.substring(4)).isEqualTo("1111");
	}

	@Test
	public void testMatchingExact() {
		final WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] { FALSE, FALSE, TRUE, TRUE });
		final WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] { FALSE, FALSE, TRUE, TRUE });
		Assertions.assertThat(one.matches(two)).isTrue();
	}

	@Test
	public void testMatchingPartial1() {
		final WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] { FALSE, WILDCARD, TRUE, TRUE });
		final WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] { FALSE, FALSE, TRUE, TRUE });
		Assertions.assertThat(one.matches(two)).isTrue();
	}

	@Test
	public void testMatchingPartial2() {
		final WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] { FALSE, WILDCARD, WILDCARD, TRUE });
		final WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] { FALSE, FALSE, TRUE, TRUE });
		Assertions.assertThat(one.matches(two)).isTrue();
	}

	@Test
	public void testNotMatching() {
		final WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] { FALSE, TRUE, WILDCARD, TRUE });
		final WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] { FALSE, FALSE, TRUE, TRUE });
		Assertions.assertThat(one.matches(two)).isFalse();
	}

	@Test
	public void testWildcardCount() {
		Assertions
				.assertThat(
						WildcardChromosome.of(new WildcardGene[] { FALSE, WILDCARD, WILDCARD, TRUE }).countWildcards())
				.isEqualTo(2);
	}

	@Test
	public void testGeneralization() {
		final WildcardChromosome one = WildcardChromosome
				.of(new WildcardGene[] { FALSE, TRUE, FALSE, TRUE, FALSE, TRUE, FALSE, TRUE });
		System.out.println("Generalize > " + one.toCanonicalString());
		final IWildcardChromosome generalize = one.generalize();
		final String canonicalString = generalize.toCanonicalString();
		System.out.println("Generalize > " + canonicalString);
		for (int i = 0; i < canonicalString.length(); i++) {
			if (canonicalString.charAt(i) != '?') {
				Assertions.assertThat(canonicalString.charAt(i)).isEqualTo(one.toCanonicalString().charAt(i));
			}
		}
	}
}
