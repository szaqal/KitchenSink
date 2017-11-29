package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

import com.google.common.base.Joiner;

import szaq.lc.ga.WildcardChromosome;
import szaq.lcs.model.Properties;
import szaq.lcs.model.Rule;

/**
 * Placeholder of learning examples.
 * 
 * @author malczyk
 *
 */
public class Env {

	private Set<Rule> trainingSet;

	private Iterator<Rule> iterator;

	public Env(final int size) {
		this.trainingSet = new HashSet<>();
		int elementsCount = size / 2;

		IntStream.range(0, elementsCount).forEach(x -> {
			trainingSet.add(trueRule());
			trainingSet.add(falseRule());
		});
		iterator = trainingSet.iterator();
	}

	private Rule trueRule() {
		return new Rule(getId().toString(), WildcardChromosome.randomTrue(), 1, Properties.init());
	}

	private Rule falseRule() {
		return new Rule(getId().toString(), WildcardChromosome.randomFalse(), 0, Properties.init());
	}

	@Override
	public String toString() {
		return Joiner.on("\n").join(trainingSet);
	}

	private String getId() {
		return UUID.randomUUID().toString();
	}

	public Rule next() {
		return iterator.hasNext() ? iterator.next() : null;
	}

}
