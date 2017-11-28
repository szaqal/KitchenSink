package szaq.lcs;

import lombok.extern.slf4j.Slf4j;

/**
 * @author malczyk
 *
 */
@Slf4j
public class Performer {

	private Env env;

	private RulePopulation rulePopulation;


	public Performer(Env env) {
		this.env = env;
		rulePopulation = new RulePopulation(30);
	}

	public void perform() throws InterruptedException {
		Rule evaluatedRule = null;
		while ((evaluatedRule = env.next()) != null) {
			MatchSet matchSet = new MatchSet(rulePopulation.match(evaluatedRule));

			log.debug("{} {}", evaluatedRule, matchSet);
			CorrectSet correctSet = new CorrectSet(evaluatedRule, matchSet);
			IncorrectSet incorrectSet = new IncorrectSet(evaluatedRule, matchSet);
			log.info("CORRECT {} | INCORRECT {}", correctSet, incorrectSet);
			if (correctSet.isEmpty()) {
				log.info("GENERALIZE {}", evaluatedRule.getCondition().toCanonicalString());
				rulePopulation.put(evaluatedRule.generalize());
			}
			
			rulePopulation.updateStatsCorrect(correctSet.getItemSet());
			rulePopulation.updateStatsIncorrect(matchSet.getItemSet());
		}
		
		log.info("{}", rulePopulation.toString());

	}

}
