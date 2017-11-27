package szaq.lcs;

import java.util.UUID;

import com.google.common.base.MoreObjects;

import io.jenetics.Phenotype;
import lombok.AllArgsConstructor;
import lombok.Data;
import szaq.lcs.api.WildcardChromosome;

@Data
@AllArgsConstructor
public class Rule {

	private String id;

	/**
	 * Condition (Genome)
	 */
	private WildcardChromosome condition;

	/**
	 * Should be {@link Phenotype}
	 */
	private int action;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getId()).addValue(getCondition().toCanonicalString())
				.addValue(action).toString();
	}
	
	public Rule generalize() {
		return new Rule(UUID.randomUUID().toString(), condition.generalize(), getAction());
	}
	
	public boolean actionMatched(Rule rule) {
		return action == rule.getAction();
	}
	
}
