package szaq.lcs.api;

import static szaq.lcs.ga.WildcardGene.FALSE;
import static szaq.lcs.ga.WildcardGene.TRUE;
import static szaq.lcs.ga.WildcardGene.WILDCARD;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import szaq.lcs.ga.LcsObjects;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Parameters;

/**
 * @author malczyk
 *
 */
public class RuleTest {

	@Test(expected = NullPointerException.class)
	public void testSubsumptionInvalidArgs() {
		final Classifier rule1 = null;
		final Classifier rule2 = null;
		final Classifier subsumer = Classifier.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubsumptionActionMismatch() {
		final Classifier rule1 = new Classifier("rule1", null, 0, Parameters.init());
		final Classifier rule2 = new Classifier("rule2", null, 1, Parameters.init());
		Classifier.getSubsumer(rule1, rule2);
	}

	@Test
	public void testSubsumptionActionSame() {
		final Classifier rule = new Classifier("rule1", null, 0, Parameters.init());
		final Classifier ruleCopy = new Classifier("rule1", null, 0, Parameters.init());
		final Classifier subsumer = Classifier.getSubsumer(rule, ruleCopy);
		Assertions.assertThat(subsumer).isEqualTo(rule);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotMatchable() {
		final Classifier rule1 = LcsObjects.anyClassifier("rule1", FALSE, FALSE, FALSE, TRUE);
		final Classifier rule2 = LcsObjects.anyClassifier("rule2", FALSE, FALSE, TRUE, TRUE);
		Classifier.getSubsumer(rule1, rule2);
	}

	@Test
	public void testSubsumption() {
		final Classifier rule1 = LcsObjects.anyClassifier("rule1", WILDCARD, FALSE, WILDCARD, TRUE);
		final Classifier rule2 = LcsObjects.anyClassifier("rule2", FALSE, FALSE, TRUE, TRUE);
		final Classifier subsumer = Classifier.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule1);
	}

	@Test
	public void testSubsumption2() {
		final Classifier rule1 = LcsObjects.anyClassifier("rule1", FALSE, FALSE, WILDCARD, TRUE);
		final Classifier rule2 = LcsObjects.anyClassifier("rule1", WILDCARD, WILDCARD, TRUE, WILDCARD);
		final Classifier subsumer = Classifier.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule2);
	}
}
