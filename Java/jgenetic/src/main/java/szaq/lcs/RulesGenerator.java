package szaq.lcs;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import com.google.common.primitives.Bytes;

import io.jenetics.BitChromosome;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class RulesGenerator {
	
	/**
	 * Randomy picked values for first byte
	 */
	private static final int PARTIAL_CHROMOSOME_LENGTH = 8;
	
	/**
	 * Values that designates action value 0 or 1 in last byte there will be only ones or zeros.
	 */
	public static final int CHROMOSOME_LENGTH = PARTIAL_CHROMOSOME_LENGTH*2;

	private int count;

	private RulesGenerator() {
	}

	public RulesGenerator(int count) {
		this();
		this.count = count;
	}

	public List<Rule> trueRules() {
		return generate(() -> BitChromosome.of(PARTIAL_CHROMOSOME_LENGTH, 1), 1);
	}

	public List<Rule> falseRules() {
		return generate(() -> BitChromosome.of(PARTIAL_CHROMOSOME_LENGTH, 0), 0);
	}
	
	private List<Rule> generate(Supplier<BitChromosome> supplier, int value) {
		List<Rule> rule = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			rule.add(Rule.builder().id(UUID.randomUUID().toString()).condition(getRandomPart(supplier)).action(value).build());
		}
		return rule;
	}

	private BitChromosome getRandomPart(Supplier<BitChromosome> supplier) {

		BitChromosome generatedChromosome = BitChromosome.of(PARTIAL_CHROMOSOME_LENGTH, 0.5);
		log.debug("> {}  {}", generatedChromosome.toCanonicalString(), generatedChromosome.toString());
		BitChromosome suffixChromosome = supplier.get();
		log.debug("> {}  {}", suffixChromosome.toCanonicalString(), suffixChromosome.toString());

		byte[] resultChromosome = concat(generatedChromosome.toByteArray(), suffixChromosome.toByteArray());
		BitChromosome result = BitChromosome.of(BitSet.valueOf(resultChromosome), PARTIAL_CHROMOSOME_LENGTH*2);
		log.debug("" + result.toCanonicalString());
		return result;
	}

	public byte[] concat(byte[] a, byte[] b) {
		return Bytes.concat(a, b);
	}

}
