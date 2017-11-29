package szaq.lcs.api;

import static szaq.lc.ga.WildcardGene.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import szaq.lc.ga.WildcardChromosome;
import szaq.lc.ga.WildcardGene;
import szaq.lcs.model.Parameters;
import szaq.lcs.model.Classifier;

/**
 * @author malczyk
 *
 */
public class RuleTest {

	@Test(expected=NullPointerException.class)
	public void testSubsumptionInvalidArgs() {
		Classifier rule1 = null;
		Classifier rule2 = null;
		Classifier subsumer = Classifier.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubsumptionActionMismatch() {
		Classifier rule1 = new Classifier("rule1", null, 0, Parameters.init());
		Classifier rule2 = new Classifier("rule2", null, 1, Parameters.init());
		Classifier.getSubsumer(rule1, rule2);
	}
	
	@Test
	public void testSubsumptionActionSame() {
		Classifier rule = new Classifier("rule1", null, 0,  Parameters.init());
		Classifier ruleCopy = new Classifier("rule1", null, 0,  Parameters.init());
		Classifier subsumer = Classifier.getSubsumer(rule, ruleCopy);
		Assertions.assertThat(subsumer).isEqualTo(rule);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNotMatchable() {
		Classifier rule1 = new Classifier("rule1", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, FALSE, TRUE}), 0,  Parameters.init());
		Classifier rule2 = new Classifier("rule2", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE}), 0,  Parameters.init());
		Classifier.getSubsumer(rule1, rule2);
	}
	
	@Test
	public void testSubsumption() {
		Classifier rule1 = new Classifier("rule1", WildcardChromosome.of(new WildcardGene[] {WILDCARD, FALSE, WILDCARD, TRUE}), 0, Parameters.init());
		Classifier rule2 = new Classifier("rule2", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE}), 0,  Parameters.init());
		Classifier subsumer = Classifier.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule1);
	}
	
	
	@Test
	public void testSubsumption2() {
		Classifier rule1 = new Classifier("rule1", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, WILDCARD, TRUE}), 0,  Parameters.init());
		Classifier rule2 = new Classifier("rule2", WildcardChromosome.of(new WildcardGene[] {WILDCARD, WILDCARD, TRUE, WILDCARD}), 0,  Parameters.init());
		Classifier subsumer = Classifier.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule2);
	}
}
