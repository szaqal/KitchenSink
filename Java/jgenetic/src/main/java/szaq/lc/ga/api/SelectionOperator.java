package szaq.lc.ga.api;

import io.vavr.Tuple2;
import szaq.lcs.model.Classifier;
import szaq.lcs.model.Population;

/**
 * Created by malczyk on 29.11.17.
 */
public interface SelectionOperator {

     Tuple2<Classifier, Classifier> select(Population rulePopulation);
}