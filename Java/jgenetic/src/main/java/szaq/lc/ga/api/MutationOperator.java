package szaq.lc.ga.api;

import szaq.lcs.model.Rule;

/**
 * Created by malczyk on 29.11.17.
 */
public interface MutationOperator {

    Rule mutate(Rule rule);
}
