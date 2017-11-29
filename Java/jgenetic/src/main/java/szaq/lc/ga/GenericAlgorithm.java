package szaq.lc.ga;

import io.vavr.Tuple2;
import szaq.lc.ga.impl.SpCrossover;
import szaq.lc.ga.impl.TournamentSelector;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Population;

/**
 * @author malczyk
 *
 */
public class GenericAlgorithm {
	
	private Population rulePopulation;

	private int generation;
	
	public GenericAlgorithm(Population rulePopulation, int generation) {
		this.rulePopulation = rulePopulation;
	}

	public void perform() {

		Tuple2<Classifier,Classifier> parents = getParents();
		new SpCrossover().doCrossover(parents._1, parents._2, generation);
	}

	private Tuple2<Classifier, Classifier> getParents() {
		return new TournamentSelector().select(rulePopulation);
	}
}
