package szaq.lcs.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WildcardChromosomeTest {

	@Test
	public void testCreate() {
		WildcardChromosome randomFalse = WildcardChromosome.random();
		String canonicalString = randomFalse.toCanonicalString();
		System.out.println("Create > " + canonicalString);
		Assertions.assertThat(canonicalString.length()).isEqualTo(8);
	}
	
	
	@Test
	public void testFalse() {
		WildcardChromosome randomFalse = WildcardChromosome.randomFalse();
		String canonicalString = randomFalse.toCanonicalString();
		System.out.println("False > " + canonicalString);
		Assertions.assertThat(canonicalString.substring(4)).isEqualTo("0000");
	}
	
	@Test
	public void testTtrue() {
		WildcardChromosome randomTrue = WildcardChromosome.randomTrue();
		String canonicalString = randomTrue.toCanonicalString();
		System.out.println("True > " + canonicalString);
		Assertions.assertThat(canonicalString.substring(4)).isEqualTo("1111");
	}
	
	@Test
	public void testMatchingExact() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.FALSE, WildcardGene.TRUE, WildcardGene.TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.FALSE, WildcardGene.TRUE, WildcardGene.TRUE});
		Assertions.assertThat(one.matches(two)).isTrue();
	}
	
	@Test
	public void testMatchingPartial1() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.WILDCARD, WildcardGene.TRUE, WildcardGene.TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.FALSE, WildcardGene.TRUE, WildcardGene.TRUE});
		Assertions.assertThat(one.matches(two)).isTrue();
	}
	
	@Test
	public void testMatchingPartial2() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.WILDCARD, WildcardGene.WILDCARD, WildcardGene.TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.FALSE, WildcardGene.TRUE, WildcardGene.TRUE});
		Assertions.assertThat(one.matches(two)).isTrue();
	}
	
	@Test
	public void testNotMatching() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.TRUE, WildcardGene.WILDCARD, WildcardGene.TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {WildcardGene.FALSE, WildcardGene.FALSE, WildcardGene.TRUE, WildcardGene.TRUE});
		Assertions.assertThat(one.matches(two)).isFalse();	
	}
}
