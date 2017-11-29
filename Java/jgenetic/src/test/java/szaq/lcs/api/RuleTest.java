package szaq.lcs.api;

import static szaq.lc.ga.WildcardGene.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import szaq.lc.ga.WildcardChromosome;
import szaq.lc.ga.WildcardGene;
import szaq.lcs.model.Rule;

/**
 * @author malczyk
 *
 */
public class RuleTest {

	@Test(expected=NullPointerException.class)
	public void testSubsumptionInvalidArgs() {
		Rule rule1 = null;
		Rule rule2 = null;
		Rule subsumer = Rule.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubsumptionActionMismatch() {
		Rule rule1 = new Rule("rule1", null, 0, 0, 0, 0);
		Rule rule2 = new Rule("rule2", null, 1, 0, 0, 0);
		Rule.getSubsumer(rule1, rule2);
	}
	
	@Test
	public void testSubsumptionActionSame() {
		Rule rule = new Rule("rule1", null, 0, 0, 0, 0);
		Rule ruleCopy = new Rule("rule1", null, 0, 0, 0, 0);
		Rule subsumer = Rule.getSubsumer(rule, ruleCopy);
		Assertions.assertThat(subsumer).isEqualTo(rule);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNotMatchable() {
		Rule rule1 = new Rule("rule1", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, FALSE, TRUE}), 0, 0, 0, 0);
		Rule rule2 = new Rule("rule2", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE}), 0, 0, 0, 0);
		Rule.getSubsumer(rule1, rule2);
	}
	
	@Test
	public void testSubsumption() {
		Rule rule1 = new Rule("rule1", WildcardChromosome.of(new WildcardGene[] {WILDCARD, FALSE, WILDCARD, TRUE}), 0, 0, 0, 0);
		Rule rule2 = new Rule("rule2", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, TRUE, TRUE}), 0, 0, 0, 0);
		Rule subsumer = Rule.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule1);
	}
	
	
	@Test
	public void testSubsumption2() {
		Rule rule1 = new Rule("rule1", WildcardChromosome.of(new WildcardGene[] {FALSE, FALSE, WILDCARD, TRUE}), 0, 0, 0, 0);
		Rule rule2 = new Rule("rule2", WildcardChromosome.of(new WildcardGene[] {WILDCARD, WILDCARD, TRUE, WILDCARD}), 0, 0, 0, 0);
		Rule subsumer = Rule.getSubsumer(rule1, rule2);
		Assertions.assertThat(subsumer).isEqualTo(rule2);
	}
}
