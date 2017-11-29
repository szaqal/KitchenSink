package szaq.lc.ga.impl;

import io.jenetics.EnumGene;
import io.vavr.Tuple2;
import szaq.lc.ga.WildcardGene;
import szaq.lc.ga.api.SelectionOperator;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Population;

/**
 * Created by malczyk on 29.11.17.
 */
public class TournamentSelector extends io.jenetics.TournamentSelector<EnumGene<WildcardGene>, Double> implements SelectionOperator {


    @Override
    public Tuple2<Classifier, Classifier> select(Population rulePopulation) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
