package szaq.lcs;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malczyk
 *
 */
@Slf4j
public class Performer {

	private Env env;

	private RulePopulation rulePopulation;

	private MatchSet matchSet;

	private CorrectSet correctSet;

	private IncorrectSet incorrectSet;

	public Performer(Env env) {
		this.env = env;
		rulePopulation = new RulePopulation(30);
		correctSet = new CorrectSet();
		incorrectSet = new IncorrectSet();
		matchSet = new MatchSet();
	}

	public void perform() {

		Rule evaluatedRule = null;
		while ((evaluatedRule = env.next()) != null) {
			if (evaluatedRule != null) {
				Set<Rule> matched = rulePopulation.match(evaluatedRule);
				log.debug("Evaluated rule matched {}", matched.size());
				if (matched.isEmpty()) {
					rulePopulation.put(evaluatedRule.generalize());
				} else {
					matchSet.addAll(matched);
					log.info("{} {}", evaluatedRule, matchSet);
				}
			}
		}
	}

}
