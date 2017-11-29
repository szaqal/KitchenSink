package szaq.lcs.func;

import java.util.function.BiPredicate;

import io.jenetics.EnumGene;
import io.jenetics.util.ISeq;
import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;

/**
 * @author malczyk
 *
 */
public class ChromosomeMatched implements BiPredicate<IWildcardChromosome, IWildcardChromosome> {

	@Override
	public boolean test(final IWildcardChromosome thiz, final IWildcardChromosome that) {
		final WildcardGene[] thisChromosome = asArray(thiz.toSeq());
		final WildcardGene[] thatChromosome = asArray(that.toSeq());

		if (thisChromosome.length != thatChromosome.length) {
			return false;
		}

		for (int i = 0; i < thisChromosome.length; i++) {
			if (!thisChromosome[i].matches(thatChromosome[i])) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns from this chromosome all genes as array
	 *
	 * @param input
	 *            sequence of genes
	 * @return array of genes
	 */
	private WildcardGene[] asArray(final ISeq<EnumGene<WildcardGene>> input) {
		return input.map(x -> x.getAllele()).toArray(new WildcardGene[input.size()]);
	}

}
