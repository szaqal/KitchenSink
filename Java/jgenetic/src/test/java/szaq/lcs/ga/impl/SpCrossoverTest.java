package szaq.lcs.ga.impl;

import static szaq.lcs.ga.WildcardGene.FALSE;
import static szaq.lcs.ga.WildcardGene.TRUE;

import org.junit.Ignore;
import org.junit.Test;

import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;
import szaq.lcs.ga.LcsObjects;
import szaq.lcs.model.Classifier;

@Slf4j
public class SpCrossoverTest {

	@Ignore
	@Test
	public void testCrossover() {
		final SpCrossover spCrossover = new SpCrossover();

		final Classifier classifier1 = LcsObjects.anyClassifier("rule1", TRUE, FALSE, TRUE, FALSE, TRUE);
		final Classifier classifier2 = LcsObjects.anyClassifier("rule2", FALSE, TRUE, FALSE, TRUE, FALSE);

		log.info("Before {} VS {}", classifier1.getCondition().toCanonicalString(),
				classifier2.getCondition().toCanonicalString());

		final Tuple2<Classifier, Classifier> doCrossover = spCrossover.doCrossover(classifier1, classifier2);

		log.info("After {} VS {}", doCrossover._1.getCondition().toCanonicalString(),
				doCrossover._2.getCondition().toCanonicalString());

	}
}
