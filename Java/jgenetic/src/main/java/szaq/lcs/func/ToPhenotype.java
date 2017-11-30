package szaq.lcs.func;

import java.util.function.Function;

import io.jenetics.EnumGene;
import io.jenetics.Genotype;
import io.jenetics.Phenotype;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;

/**
 * @author malczyk
 *
 */
public class ToPhenotype implements Function<IWildcardChromosome, Phenotype<EnumGene<WildcardGene>, Double>> {

	private final int currentGeneration;
	private final Function<Genotype<EnumGene<WildcardGene>>, Double> fitness = null;

	public ToPhenotype(final int currentGeneration) {
		this.currentGeneration = currentGeneration;
	}

	@Override
	public Phenotype<EnumGene<WildcardGene>, Double> apply(final IWildcardChromosome chromosome) {
		// TODO: use function composition
		final Genotype<EnumGene<WildcardGene>> genotype = ToGenotype.get(chromosome);

		return Phenotype.of(genotype, currentGeneration, fitness);
	}

}
