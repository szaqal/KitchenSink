package szaq.lcs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class RuleWildcardTest {

	@Test
	public void testToString() {
		List<Rule> trueRules = new RulesGenerator(10).trueRules();
		for(Rule rule:trueRules) {
			RuleWildcard wildcardRule = RuleWildcard.of(rule);
			
			Set<Integer> comparablePositions = wildcardRule.getComparablePositions();
			String value = wildcardRule.toString();
			for(int position: comparablePositions) {
				char charAt = value.charAt(position);
				//System.out.println(position +" | "+charAt);
				Assertions.assertThat(charAt).isNotEqualTo(RuleWildcard.WILDCARD_CHAR);
			}
			System.out.println(value);
		}
	}
	
	@Test
	public void testMatch() {
		Iterator<Rule> trueRules = new RulesGenerator(2).trueRules().iterator();
		RuleWildcard rule1 = RuleWildcard.of(trueRules.next());
		RuleWildcard rule2 = RuleWildcard.of(trueRules.next());
		Assertions.assertThat(rule1.matches(rule2)).isTrue();
	}

}
