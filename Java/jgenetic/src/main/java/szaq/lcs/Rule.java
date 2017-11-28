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
	
	/**
	 * number of copies ?
	 */
	private int numerocity;
	
	/**
	 * numer of times it's been on a match set
	 */
	private int matchCount;
	
	/**
	 * numer of times it's been on a correct set
	 */
	private int correctCount;
	
	/**
	 * correct count/match count
	 */
	private int accuracy;
	

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getId()).addValue(getCondition().toCanonicalString())
				.addValue(action).addValue(numerocity).addValue(matchCount).addValue(correctCount).toString();
	}
	
	public Rule generalize() {
		return new Rule(UUID.randomUUID().toString(), condition.generalize(), getAction(), 0,0,0,0);
	}
	
	public boolean actionMatched(Rule rule) {
		return action == rule.getAction();
	}
	
	public void increaseMatchCount() {
		matchCount +=1;
	}
	
	public void increatesCorrectCount() {
		correctCount +=1;
	}
	
	
}
