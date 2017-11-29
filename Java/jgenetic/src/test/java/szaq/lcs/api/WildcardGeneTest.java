package szaq.lcs.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import szaq.lc.ga.WildcardGene;

public class WildcardGeneTest {

	@Test
	public void testMatching() {
		Assertions.assertThat(WildcardGene.WILDCARD.matches(WildcardGene.FALSE)).isTrue();
		Assertions.assertThat(WildcardGene.WILDCARD.matches(WildcardGene.TRUE)).isTrue();
		Assertions.assertThat(WildcardGene.WILDCARD.matches(WildcardGene.WILDCARD)).isTrue();
		Assertions.assertThat(WildcardGene.TRUE.matches(WildcardGene.TRUE)).isTrue();
		Assertions.assertThat(WildcardGene.FALSE.matches(WildcardGene.FALSE)).isTrue();
		Assertions.assertThat(WildcardGene.TRUE.matches(WildcardGene.FALSE)).isFalse();
		Assertions.assertThat(WildcardGene.FALSE.matches(WildcardGene.TRUE)).isFalse();
	}
	
}
