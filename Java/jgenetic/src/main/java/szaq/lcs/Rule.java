package szaq.lcs;

import com.google.common.base.MoreObjects;

import io.jenetics.BitChromosome;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rule {
	
	private String id;
	
	/**
	 * Condition  (Genome)
	 */
	private BitChromosome condition;
	
	/**
	 * Should be {@link Phenotype}
	 */
	private int action;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getId()).addValue(getCondition().toCanonicalString()).addValue(action).toString();
	}
}
