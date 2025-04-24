package szaq.lcs.func;

import static szaq.lcs.ga.WildcardGene.TRUE;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import io.jenetics.Chromosome;
import io.jenetics.EnumGene;
import io.jenetics.Phenotype;
import szaq.lcs.ga.LcsObjects;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;

public class ToPhenotypeTest {

	@Test
	public void testFunction() {
		final IWildcardChromosome anyChromosome = LcsObjects.anyChromosome(TRUE, TRUE, TRUE, TRUE);
		final Phenotype<EnumGene<WildcardGene>, Double> result = new ToPhenotype(1).apply(anyChromosome);
		Assertions.assertThat(result).isNotNull();
		final Chromosome<EnumGene<WildcardGene>> chromosome = result.getGenotype().getChromosome(0);
		Assertions.assertThat(chromosome.getGene().getAllele()).isEqualTo(TRUE);
	}
}
