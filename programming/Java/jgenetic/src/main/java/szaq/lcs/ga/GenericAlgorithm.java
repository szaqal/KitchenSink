package szaq.lcs.ga;

import io.vavr.Tuple2;
import szaq.lcs.ga.impl.SpCrossover;
import szaq.lcs.ga.impl.TournamentSelector;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Population;

/**
 * @author malczyk
 *
 */
public class GenericAlgorithm {

	private final Population rulePopulation;

	private int generation;

	public GenericAlgorithm(final Population rulePopulation, final int generation) {
		this.rulePopulation = rulePopulation;
	}

	public void perform() {

		final Tuple2<Classifier, Classifier> parents = getParents();
		new SpCrossover().doCrossover(parents._1, parents._2);
	}

	private Tuple2<Classifier, Classifier> getParents() {
		return new TournamentSelector().select(rulePopulation);
	}
}
