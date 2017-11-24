package lcs;

import com.google.common.base.MoreObjects;

import io.jenetics.BitChromosome;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rule {
	
	private BitChromosome chromosome;
	
	private int action;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getChromosome().toCanonicalString()).addValue(action).toString();
	}
}
