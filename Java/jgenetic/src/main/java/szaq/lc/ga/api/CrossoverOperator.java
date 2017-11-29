package szaq.lc.ga.api;

import szaq.lcs.model.Rule;

public interface CrossoverOperator {
	
	void doCrossover(Rule parent1, Rule parent2, int generation);

}
