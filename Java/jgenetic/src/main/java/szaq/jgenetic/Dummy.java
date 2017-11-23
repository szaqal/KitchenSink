package szaq.jgenetic;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

/**
 * Hello world!
 *
 */
public class Dummy {

	private static int eval(Genotype<BitGene> gt) {
		return gt.getChromosome().as(BitChromosome.class).bitCount();
	}

	public static void main(String[] args) {
		Factory<Genotype<BitGene>> gtf = Genotype.of(BitChromosome.of(10, 0.5));

		Engine<BitGene, Integer> engine = Engine.builder(Dummy::eval, gtf).build();

		Genotype<BitGene> result = engine.stream().limit(100_000).collect(EvolutionResult.toBestGenotype());

		System.out.println("World : \n\t" + result);
	}
}
