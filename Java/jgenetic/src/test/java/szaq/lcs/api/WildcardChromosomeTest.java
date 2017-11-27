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
}
