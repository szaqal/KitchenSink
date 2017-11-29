package szaq.lc.ga.impl;

import io.jenetics.EnumGene;
import io.jenetics.SinglePointCrossover;
import szaq.lc.ga.WildcardGene;
import szaq.lc.ga.api.CrossoverOperator;
import szaq.lcs.model.Rule;

/**
 * @see {@link io.jenetics.Crossover}
 * @author malczyk
 *
 */
public class SpCrossover extends SinglePointCrossover<EnumGene<WildcardGene>, Double> implements CrossoverOperator {

	@Override
	public void doCrossover(Rule parent1, Rule parent2, int generation) {
		// TODO: implement
		//recombine(parent1, parent2, generation);
	}

}
