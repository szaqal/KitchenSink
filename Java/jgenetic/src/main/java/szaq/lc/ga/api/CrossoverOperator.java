package szaq.lc.ga.api;

import szaq.lcs.model.Classifier;

public interface CrossoverOperator {
	
	void doCrossover(Classifier parent1, Classifier parent2, int generation);

}
