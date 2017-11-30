package szaq.lcs.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;

/**
 * This is where we'll store solution candidates
 *
 * @author malczyk
 *
 */
@Slf4j
public class Population {

	private final int size;

	private final Set<Classifier> rules = new HashSet<>();

	private int currentGeneration;

	/**
	 * Creates initial rule population
	 *
	 * @param size
	 *            rule population size
	 */
	public Population(final int size) {
		this.size = size;
	}

	public Set<Classifier> match(final Classifier rule) {
		return rules.stream().filter(x -> x.getCondition().matches(rule.getCondition())).collect(Collectors.toSet());
	}

	public Set<Classifier> getRules() {
		return rules;
	}

	public void put(final Classifier rule) {
		if (rules.size() == size) {
			throw new UnsupportedOperationException("Rule to big");
		}
		rules.add(rule);
		log.debug("{} added -> size {}", rule.toString(), rules.size());
	}

	@Override
	public String toString() {
		return Joiner.on("\n").join(rules);
	}

	public void updateStatsIncorrect(final Set<Classifier> matched) {
		for (final Classifier rule : matched) {
			if (rules.contains(rule)) {
				rule.increaseMatchCount();
			}
		}
	}

	public void updateStatsCorrect(final Set<Classifier> matched) {
		for (final Classifier rule : matched) {
			if (rules.contains(rule)) {
				rule.increaseMatchCount();
				rule.increatesCorrectCount();
			}
		}
	}

	public void nextGen() {
		currentGeneration += 1;
	}

	public int getCurrentGeneration() {
		return currentGeneration;
	}

}
