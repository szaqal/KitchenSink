package szaq.lc.ga.api;

import io.vavr.Tuple2;
import szaq.lcs.model.Rule;
import szaq.lcs.model.RulePopulation;

/**
 * Created by malczyk on 29.11.17.
 */
public interface SelectionOperator {

     Tuple2<Rule, Rule> select(RulePopulation rulePopulation);
}