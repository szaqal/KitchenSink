package szaq.lcs.ga.api;

import io.jenetics.Chromosome;
import io.jenetics.EnumGene;
import szaq.lcs.ga.WildcardGene;

/**
 * @author malczyk
 *
 */
public interface IWildcardChromosome extends Chromosome<EnumGene<WildcardGene>> {

	/**
	 * Does generalization of more specific rule that is for given 110011 it could
	 * be 1?00??.
	 *
	 * @return generalized chromosome
	 */
	IWildcardChromosome generalize();

	/**
	 * Verifies if "that" chromosome is matching this. Wildcard is matching
	 * everything for example "??11" matches both "0011" and "1111"
	 *
	 * @param that
	 *            chromosome being matched
	 *
	 * @return true if matching
	 */
	boolean matches(IWildcardChromosome condition);

	/**
	 * Returns count of wildcard values in this chromosome.
	 *
	 * 00??11 -> 2
	 *
	 * @return number of occuring wildcards.
	 */
	long countWildcards();

	/**
	 * Returns formatted chromosome value.
	 *
	 * @return string representation
	 */
	String toCanonicalString();
}
