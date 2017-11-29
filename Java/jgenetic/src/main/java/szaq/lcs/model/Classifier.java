package szaq.lcs.model;

import java.util.Objects;
import java.util.UUID;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import io.jenetics.Phenotype;
import lombok.AllArgsConstructor;
import lombok.Data;
import szaq.lc.ga.WildcardChromosome;

/**
 * Classifier represents potential solution.
 *
 * General definition
 *
 * <pre>
 * Classifier(n) = Condition : Action :: Parameter(s)
 * </pre>
 *
 * @author malczyk
 *
 */
@Data
@AllArgsConstructor
public final class Classifier {

	private String id;

	/**
	 * Condition (Genome)
	 */
	private WildcardChromosome condition;

	/**
	 * Should be {@link Phenotype}
	 */
	private int action;

	private Parameters parameters;

	public static Classifier getSubsumer(final Classifier inputClassifier1, final Classifier inputClassifier2) {

		final Classifier classifier1 = Objects.requireNonNull(inputClassifier1, "Missing input rule 1");
		final Classifier classifier2 = Objects.requireNonNull(inputClassifier2, "Missing input rule 2");
		Preconditions.checkArgument(classifier1.actionMatched(classifier2), "Action mismatch");
		if (classifier1.equals(classifier2)) {
			return classifier1;
		}

		if (!classifier1.getCondition().matches(classifier2.getCondition())) {
			throw new IllegalArgumentException("Non maching conditions");
		}

		final long wildcards1 = classifier1.getCondition().countWildcards();
		final long wildcards2 = classifier2.getCondition().countWildcards();

		if (wildcards1 == wildcards2 || wildcards1 > wildcards2) {
			return classifier1;
		} else {
			return classifier2;
		}
	}

	public boolean actionMatched(final Classifier rule) {
		return action == rule.getAction();
	}

	public Classifier generalize() {
		return new Classifier(UUID.randomUUID().toString(), condition.generalize(), getAction(), Parameters.init());
	}

	public void increaseMatchCount() {
		parameters.increaseMatchCount();
	}

	public void increatesCorrectCount() {
		parameters.increatesCorrectCount();
	}

	@Override
	public String toString() {
		//@formatter:off
		return MoreObjects.toStringHelper(this)
				.addValue(getId())
				.addValue(getCondition().toCanonicalString())
				.addValue(action)
				.addValue(getParameters()).toString();
		//@formatter:on
	}
}
