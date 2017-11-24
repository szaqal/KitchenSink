package lcs;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.function.Supplier;

import io.jenetics.BitChromosome;

public final class RulesGenerator {

	private static final int CHROMOSOME_LENGTH = 8;

	private static final Supplier<BitChromosome> TRUE_ONLY = () -> BitChromosome.of(CHROMOSOME_LENGTH, 1);
	private static final Supplier<BitChromosome> FALSE_ONLY = () -> BitChromosome.of(CHROMOSOME_LENGTH, 0);

	private int count;

	private RulesGenerator() {
	}

	public RulesGenerator(int count) {
		this.count = count;
	}

	public List<Rule> classARules() {
		List<Rule> rule = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			rule.add(Rule.builder().chromosome(getRandomPart(TRUE_ONLY)).action(0).build());
		}
		return rule;
	}

	public List<Rule> classBRules() {
		List<Rule> rule = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			rule.add(Rule.builder().chromosome(getRandomPart(FALSE_ONLY)).action(1).build());
		}
		return rule;
	}

	private BitChromosome getRandomPart(Supplier<BitChromosome> supplier) {

		BitChromosome generatedChromosome = BitChromosome.of(CHROMOSOME_LENGTH, 0.5);
		System.out.println(">" + generatedChromosome.toCanonicalString() + ">" + generatedChromosome.toString());
		BitChromosome suffixChromosome = supplier.get();
		System.out.println(">" + suffixChromosome.toCanonicalString() + ">" + suffixChromosome.toString());

		byte[] suffixArr = generatedChromosome.toByteArray();
		System.out.println(">" + BitChromosome.of(BitSet.valueOf(suffixArr), CHROMOSOME_LENGTH).toCanonicalString());

		byte[] resultChromosome = concat(generatedChromosome.toByteArray(), suffixChromosome.toByteArray());
		System.out.println(">" + BitChromosome.of(BitSet.valueOf(resultChromosome), CHROMOSOME_LENGTH*2).toCanonicalString());
		return null;
	}

	public byte[] concat(byte[] a, byte[] b) {
		int length = a.length + b.length;
		byte[] result = new byte[length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

}
