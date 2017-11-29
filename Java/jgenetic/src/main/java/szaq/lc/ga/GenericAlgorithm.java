package szaq.lc.ga;

import io.vavr.Tuple2;
import szaq.lc.ga.impl.SpCrossover;
import szaq.lc.ga.impl.TournamentSelector;
import szaq.lcs.model.Rule;
import szaq.lcs.model.RulePopulation;

/**
 * @author malczyk
 *
 */
public class GenericAlgorithm {
	
	private RulePopulation rulePopulation;

	private int generation;
	
	public GenericAlgorithm(RulePopulation rulePopulation, int generation) {
		this.rulePopulation = rulePopulation;
	}

	public void perform() {

		Tuple2<Rule,Rule> parents = getParents();
		new SpCrossover().doCrossover(parents._1, parents._2, generation);
	}

	private Tuple2<Rule, Rule> getParents() {
		return new TournamentSelector().select(rulePopulation);
	}
}
