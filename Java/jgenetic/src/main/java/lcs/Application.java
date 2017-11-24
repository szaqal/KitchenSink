package lcs;

public class Application {
	
	private static final int CLASSCOUNT = 100;
	
	public static void main(String[]args) {
		new RulesGenerator(CLASSCOUNT).trueRules();
		new RulesGenerator(CLASSCOUNT).falseRules();
		System.out.println("done");
	}

}
