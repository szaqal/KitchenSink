package szaq.lcs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

import com.google.common.base.Joiner;

import szaq.lcs.api.WildcardChromosome;

/**
 * Placeholder of learning examples.
 * @author malczyk
 *
 */
public class Env {

	private Set<Rule> trainingSet;
	
	private Iterator<Rule> iterator;
	
	

	public Env(final int size) {
		this.trainingSet = new HashSet<>();
		int elementsCount = size/2;
		IntStream.range(0, elementsCount).forEach(x->trainingSet.add(new Rule(getId(), WildcardChromosome.randomFalse(), 0,0,0,0,0)));
		IntStream.range(0, elementsCount).forEach(x->trainingSet.add(new Rule(getId().toString(), WildcardChromosome.randomTrue(), 1,0,0,0,0)));
		iterator = trainingSet.iterator();
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
