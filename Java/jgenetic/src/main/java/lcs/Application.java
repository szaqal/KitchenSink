package lcs;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
	
	private static final int CLASSCOUNT = 100;
	
	public static void main(String[]args) {
		List<Rule> rules = new ArrayList<Rule>();
		List<Rule> trueRules = new RulesGenerator(CLASSCOUNT).trueRules();
		List<Rule> falseRules = new RulesGenerator(CLASSCOUNT).falseRules();

		
		rules.addAll(trueRules);
		rules.addAll(falseRules);
		log.info(new TrainRules(rules).toString());
	}

}
