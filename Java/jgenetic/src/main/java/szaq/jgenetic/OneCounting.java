package szaq.jgenetic;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.Mutator;
import io.jenetics.Phenotype;
import io.jenetics.RouletteWheelSelector;
import io.jenetics.SinglePointCrossover;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionStatistics;
import static io.jenetics.engine.Limits.*;
import static io.jenetics.engine.EvolutionResult.*;

public class OneCounting {
	
	private static Integer count(Genotype<BitGene> gt) {
		return gt.getChromosome().as(BitChromosome.class).bitCount();
	}
	
	public static void main(String[]args) {
		Engine<BitGene, Integer> engine = Engine.builder(OneCounting::count, BitChromosome.of(10,0.15))
		.populationSize(10)
		.selector(new RouletteWheelSelector<>()).alterers(new Mutator<>(0.55), new SinglePointCrossover<>())
		.build();
		
		EvolutionStatistics<Integer, ?> statistics = EvolutionStatistics.ofNumber();
		
		Phenotype<BitGene , Integer> best = engine.stream ()
				.limit(bySteadyFitness(7))
				.limit(100)
				. peek(statistics)
				. collect(toBestPhenotype()) ;
		
		System.out.println(best.getFitness());
		System.out.println(best.getGenotype().getChromosome(0));
		//System.out.println(statistics) ;
		System.out.println(best) ;
	}
 
}
