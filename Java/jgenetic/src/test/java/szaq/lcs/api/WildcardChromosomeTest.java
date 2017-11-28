package szaq.lcs.api;

import static szaq.lcs.api.WildcardGene.FALSE;
import static szaq.lcs.api.WildcardGene.TRUE;
import static szaq.lcs.api.WildcardGene.WILDCARD;

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
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE});
		Assertions.assertThat(one.matches(two)).isTrue();
	}
	
	@Test
	public void testMatchingPartial1() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {FALSE, WILDCARD, TRUE, TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE});
		Assertions.assertThat(one.matches(two)).isTrue();
	}
	
	@Test
	public void testMatchingPartial2() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {FALSE, WILDCARD, WILDCARD, TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE});
		Assertions.assertThat(one.matches(two)).isTrue();
	}
	
	@Test
	public void testNotMatching() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {FALSE, TRUE, WILDCARD, TRUE});
		WildcardChromosome two = WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE});
		Assertions.assertThat(one.matches(two)).isFalse();	
	}
	
	@Test
	public void testWildcardCount() {
		Assertions.assertThat(WildcardChromosome.of(new WildcardGene[] {FALSE, WILDCARD, WILDCARD, TRUE}).countWildcards()).isEqualTo(2);
	}
	
	@Test
	public void testGeneralization() {
		WildcardChromosome one = WildcardChromosome.of(new WildcardGene[] {FALSE, TRUE, FALSE, TRUE, FALSE, TRUE, FALSE, TRUE});
		System.out.println("Generalize > "+ one.toCanonicalString());
		WildcardChromosome generalize = one.generalize();
		String canonicalString = generalize.toCanonicalString();
		System.out.println("Generalize > "+ canonicalString);
		for(int i=0;i<canonicalString.length();i++ ) {
			if(canonicalString.charAt(i)!='?') {
				Assertions.assertThat(canonicalString.charAt(i)).isEqualTo(one.toCanonicalString().charAt(i));
			}
		}
	}
}
