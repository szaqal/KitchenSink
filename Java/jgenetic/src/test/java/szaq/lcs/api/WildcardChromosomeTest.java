package szaq.lcs.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WildcardChromosomeTest {

	@Test
	public void testCreate() {
		WildcardChromosome randomFalse = WildcardChromosome.random();
		Assertions.assertThat(randomFalse.toCanonicalString()).isEqualTo("");
	}
}
