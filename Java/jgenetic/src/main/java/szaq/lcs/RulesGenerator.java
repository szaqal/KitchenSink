package szaq.lcs;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.function.Supplier;

import io.jenetics.BitChromosome;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class RulesGenerator {

	private static final int CHROMOSOME_LENGTH = 8;

	private static final Supplier<BitChromosome> TRUE_ONLY = () -> BitChromosome.of(CHROMOSOME_LENGTH, 1);
	private static final Supplier<BitChromosome> FALSE_ONLY = () -> BitChromosome.of(CHROMOSOME_LENGTH, 0);

	private int count;

	private RulesGenerator() {
	}

	public RulesGenerator(int count) {
		this();
		this.count = count;
	}

	public List<Rule> trueRules() {
		return generate(TRUE_ONLY, 1);
	}

	public List<Rule> falseRules() {
		return generate(FALSE_ONLY, 0);
	}
	
	private List<Rule> generate(Supplier<BitChromosome> supplier, int value) {
		List<Rule> rule = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			rule.add(Rule.builder().chromosome(getRandomPart(supplier)).action(value).build());
		}
		return rule;
	}

	private BitChromosome getRandomPart(Supplier<BitChromosome> supplier) {

		BitChromosome generatedChromosome = BitChromosome.of(CHROMOSOME_LENGTH, 0.5);
		log.debug("> {}  {}", generatedChromosome.toCanonicalString(), generatedChromosome.toString());
		BitChromosome suffixChromosome = supplier.get();
		log.debug("> {}  {}", suffixChromosome.toCanonicalString(), suffixChromosome.toString());

		byte[] resultChromosome = concat(generatedChromosome.toByteArray(), suffixChromosome.toByteArray());
		BitChromosome result = BitChromosome.of(BitSet.valueOf(resultChromosome), CHROMOSOME_LENGTH*2);
		log.debug("" + result.toCanonicalString());
		return result;
	}

	public byte[] concat(byte[] a, byte[] b) {
		int length = a.length + b.length;
		byte[] result = new byte[length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

}
