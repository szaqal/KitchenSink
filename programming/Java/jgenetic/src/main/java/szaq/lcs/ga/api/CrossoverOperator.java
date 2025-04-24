package szaq.lcs.ga.api;

import io.vavr.Tuple2;
import szaq.lcs.model.Classifier;

public interface CrossoverOperator {

	/**
	 *
	 * @param parent1
	 * @param parent2
	 * @param generation
	 * @return
	 */
	Tuple2<Classifier, Classifier> doCrossover(Classifier parent1, Classifier parent2);

}
