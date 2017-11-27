package szaq.lcs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToIntFunction;

import com.google.common.base.Joiner;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import lombok.extern.slf4j.Slf4j;
import szaq.lcs.api.WildcardChromosome;

@Slf4j
public class RuleWildcard extends Rule {

	public static final char WILDCARD_CHAR = '#';

	private Set<Integer> comparablePositions = new HashSet<>();

	/**
	 * @see {@link BitChromosome} Maps ZERO/TRUE literal to 1 or 0
	 */
	private static final ToIntFunction<BitGene> AS_INT = x -> x.booleanValue() ? 1 : 0;

	private RuleWildcard(String id, WildcardChromosome condition, int action) {
		super(id, condition, action);

		int[] values = asInts();
		int randomNum = getRandom(values);
		log.debug("Random vars {}", randomNum);
		for (int i = 0; i < randomNum; i++) {
			int randomPosition = getRandom(values);
			comparablePositions.add(randomPosition);
		}

		log.debug("comparable positions {}", comparablePositions);
	}

	private int[] asInts() {
		return new int[] {}; 
		//getCondition().stream().mapToInt(AS_INT).toArray();
	}

	private int getRandom(int[] values) {
		return ThreadLocalRandom.current().nextInt(0, values.length);
	}

	public static RuleWildcard of(Rule rule) {
		//FIXME:
		return null;
		//return new RuleWildcard(UUID.randomUUID().toString(), rule.getCondition(), rule.getAction());
	}

	public Set<Integer> getComparablePositions() {
		return comparablePositions;
	}

	// TODO: matching by string representation is a crap fix later however
	// BitChoromosome does not support wildcards
	public boolean matches(RuleWildcard other) {
		String thisVal = toString();
		String otherVal = other.toString();
		log.info("{} {}", thisVal, otherVal);

		if (thisVal.length() != otherVal.length()) {
			return false;
		}

		boolean result = true;
		for (int i = 0; i < thisVal.length(); i++) {
			char a = thisVal.charAt(i);
			char b = otherVal.charAt(i);
			if (a != WILDCARD_CHAR && b != WILDCARD_CHAR) {
				result = a == b;
			}
			log.debug("matched {} {} {}", a, b, result);
			if(!result) {
				break;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		int[] asInts = asInts();
		List<String> values = new ArrayList<>();
		for (int i = 0; i < asInts.length; i++) {
			boolean contains = comparablePositions.contains(i);
			values.add(contains ? String.valueOf(asInts[i]) : "#");
		}
		return Joiner.on("").join(values);
	}

}
