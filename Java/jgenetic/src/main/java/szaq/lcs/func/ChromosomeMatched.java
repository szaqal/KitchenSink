package szaq.lcs.func;

import java.util.function.BiPredicate;

import szaq.lcs.ga.WildcardGene;
import szaq.lcs.ga.api.IWildcardChromosome;

/**
 * Predicate that returns true whenever chromosomes are matched that is either
 * full matched or partial matched when wildcards are present.
 *
 * @author malczyk
 *
 */
public class ChromosomeMatched implements BiPredicate<IWildcardChromosome, IWildcardChromosome> {

	@Override
	public boolean test(final IWildcardChromosome thiz, final IWildcardChromosome that) {

		final WildcardGene[] thisChromosome = thiz.asArray();
		final WildcardGene[] thatChromosome = that.asArray();

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

}
