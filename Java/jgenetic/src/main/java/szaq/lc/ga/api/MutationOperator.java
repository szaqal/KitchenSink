package szaq.lc.ga.api;

import szaq.lcs.model.Classifier;

/**
 * Created by malczyk on 29.11.17.
 */
public interface MutationOperator {

    Classifier mutate(Classifier rule);
}
