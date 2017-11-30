package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

import com.google.common.base.Joiner;

import szaq.lcs.ga.LcsObjects;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Parameters;

/**
 * Placeholder of learning examples.
 *
 * @author malczyk
 *
 */
public class Env {

	private final Set<Classifier> trainingSet;

	private final Iterator<Classifier> iterator;

	public Env(final int size) {
		this.trainingSet = new HashSet<>();
		final int elementsCount = size / 2;

		IntStream.range(0, elementsCount).forEach(x -> {
			trainingSet.add(trueRule());
			trainingSet.add(falseRule());
		});
		iterator = trainingSet.iterator();
	}

	private Classifier trueRule() {
		return new Classifier(getId().toString(), LcsObjects.randomTrue(), 1, Parameters.init());
	}

	private Classifier falseRule() {
		return new Classifier(getId().toString(), LcsObjects.randomFalse(), 0, Parameters.init());
	}

	@Override
	public String toString() {
		return Joiner.on("\n").join(trainingSet);
	}

	private String getId() {
		return UUID.randomUUID().toString();
	}

	public Classifier next() {
		return iterator.hasNext() ? iterator.next() : null;
	}

}
