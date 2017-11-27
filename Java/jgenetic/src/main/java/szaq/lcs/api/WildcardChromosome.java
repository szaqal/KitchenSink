package szaq.lcs.api;

import static java.util.stream.Collectors.joining;

import io.jenetics.AbstractChromosome;
import io.jenetics.EnumGene;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;

/**
 * @author malczyk
 *
 */
public class WildcardChromosome extends AbstractChromosome<EnumGene<WildcardGeneValue>> {

	protected WildcardChromosome(ISeq<? extends EnumGene<WildcardGeneValue>> genes) {
		super(genes);
	}

	private static final int DEFAULT_LENGTH = 8;

	private static final long serialVersionUID = 6027715032396038105L;


	
	public String toCanonicalString() {
		return toSeq().stream().map(g -> g.getAllele().getValue()).collect(joining());
	}
	
	@Override
	public WildcardChromosome newInstance(ISeq<EnumGene<WildcardGeneValue>> genes) {
		return new WildcardChromosome(genes);
	}

	@Override
	public WildcardChromosome newInstance() {
		return new WildcardChromosome(WildcardGeneValue.seq(IntRange.of(DEFAULT_LENGTH)));
	}
	
	public static WildcardChromosome random() {
		return new WildcardChromosome(WildcardGeneValue.seq(IntRange.of(DEFAULT_LENGTH)));
	}

}
