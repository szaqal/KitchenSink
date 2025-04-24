package szaq.lcs.func;

import java.util.function.Function;

import io.jenetics.EnumGene;
import io.jenetics.Genotype;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;

/**
 * @author malczyk
 *
 */
public class ToGenotype implements Function<IWildcardChromosome, Genotype<EnumGene<WildcardGene>>> {

	@Override
	public Genotype<EnumGene<WildcardGene>> apply(final IWildcardChromosome wildcardChromosome) {
		return Genotype.of(wildcardChromosome);
	}

	public static Genotype<EnumGene<WildcardGene>> get(final IWildcardChromosome wildcardChromosome) {
		return new ToGenotype().apply(wildcardChromosome);
	}

}
