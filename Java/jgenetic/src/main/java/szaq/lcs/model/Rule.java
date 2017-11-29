package szaq.lcs.model;

import java.util.Objects;
import java.util.UUID;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import io.jenetics.Phenotype;
import lombok.AllArgsConstructor;
import lombok.Data;
import szaq.lcs.api.WildcardChromosome;

/**
 * @author malczyk
 *
 */
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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.addValue(getId())
				.addValue(getCondition().toCanonicalString())
				.addValue(action)
				.addValue(numerocity)
				.addValue(matchCount)
				.addValue(correctCount)
				.addValue(getAccuracy()).toString();
	}

	public Rule generalize() {
		return new Rule(UUID.randomUUID().toString(), condition.generalize(), getAction(), 0, 0, 0);
	}

	public boolean actionMatched(Rule rule) {
		return action == rule.getAction();
	}

	public void increaseMatchCount() {
		matchCount += 1;
	}

	public void increatesCorrectCount() {
		correctCount += 1;
	}

	public double getAccuracy() {
		if (matchCount == 0) {
			return 0.0;
		}
		return correctCount / matchCount;
	}
	

	public static Rule getSubsumer(final Rule inputRule1, final Rule inputRule2) {
		
		Rule rule1 = Objects.requireNonNull(inputRule1, "Missing input rule 1");
		Rule rule2 = Objects.requireNonNull(inputRule2, "Missing input rule 2");
		Preconditions.checkArgument(rule1.actionMatched(rule2), "Action mismatch");
		if (rule1.equals(rule2)) {
			return rule1;
		}

		if (!rule1.getCondition().matches(rule2.getCondition())) {
			throw new IllegalArgumentException("Non maching conditions");
		}

		long wildcards1 = rule1.getCondition().countWildcards();
		long wildcards2 = rule2.getCondition().countWildcards();
		
		if (wildcards1 == wildcards2 || wildcards1 > wildcards2) {
			return rule1;
		} else {
			return rule2;
		}
	}

}
