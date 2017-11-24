package lcs;

import io.jenetics.BitChromosome;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rule {
	
	private BitChromosome chromosome;
	
	private int action;
}
