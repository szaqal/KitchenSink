package szaq.lcs;

/**
 * Matching and with correct classes
 * @author malczyk
 *
 */
public class CorrectSet extends BaseMatchingSet {
	
	
	
	public CorrectSet(final Rule evaluatedRule, final MatchSet matchSet) {
		super(evaluatedRule, matchSet, (x, y) -> x.getAction() == y.getAction());
	}

}
