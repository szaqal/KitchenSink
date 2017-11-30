package szaq.lcs;

import lombok.extern.slf4j.Slf4j;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.CorrectSet;
import szaq.lcs.model.IncorrectSet;
import szaq.lcs.model.MatchSet;
import szaq.lcs.model.Population;

/**
 * @author malczyk
 *
 */
@Slf4j
public class Performer {

	private final Env env;

	private final Population rulePopulation;

	public Performer(final Env env) {
		this.env = env;
		rulePopulation = new Population(30);
	}

	public void perform() throws InterruptedException {
		Classifier evaluatedRule = null;
		while ((evaluatedRule = env.next()) != null) {
			final MatchSet matchSet = new MatchSet(rulePopulation.match(evaluatedRule));

			log.debug("{} {}", evaluatedRule, matchSet);
			final CorrectSet correctSet = new CorrectSet(evaluatedRule, matchSet);
			final IncorrectSet incorrectSet = new IncorrectSet(evaluatedRule, matchSet);
			log.info("CORRECT {} | INCORRECT {}", correctSet, incorrectSet);
			if (correctSet.isEmpty()) {
				log.info("GENERALIZE {}", evaluatedRule.getCondition().toCanonicalString());
				rulePopulation.put(evaluatedRule.generalize());
			}

			rulePopulation.updateStatsCorrect(correctSet.getItemSet());
			rulePopulation.updateStatsIncorrect(matchSet.getItemSet());
			// rulePopulation.doSubsumption();
		}

		log.info("{}", rulePopulation.toString());

	}

}
