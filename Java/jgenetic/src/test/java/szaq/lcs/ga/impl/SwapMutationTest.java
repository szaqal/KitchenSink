package szaq.lcs.ga.impl;

import static szaq.lcs.ga.WildcardGene.FALSE;
import static szaq.lcs.ga.WildcardGene.TRUE;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import szaq.lcs.ga.WildcardChromosome;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.MutationOperator;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Parameters;

/**
 * @author malczyk
 *
 */
@Slf4j
public class SwapMutationTest {

	@Test
	public void testSwapMutation() {
		final MutationOperator mutation = new SwapMutation(1);

		final WildcardGene[] inital = new WildcardGene[] { TRUE, FALSE, FALSE, FALSE, FALSE };
		final WildcardChromosome origin = WildcardChromosome.of(inital);

		final WildcardChromosome initChromosome = WildcardChromosome.of(inital);
		final Classifier classifier = new Classifier("rule1", initChromosome, 0, Parameters.init());
		final String beforeMutation = classifier.getCondition().toCanonicalString();
		log.info("{} vs {}", beforeMutation, WildcardChromosome.of(inital).toCanonicalString());
		// -- Mutate
		mutation.mutate(classifier);

		log.info("{} vs {}", beforeMutation, classifier.getCondition().toCanonicalString());

		Assertions.assertThat(classifier.getCondition().countWildcards())
				.isEqualByComparingTo(classifier.getCondition().countWildcards());
		Assertions.assertThat(origin.matches(classifier.getCondition())).isFalse();
	}
}
