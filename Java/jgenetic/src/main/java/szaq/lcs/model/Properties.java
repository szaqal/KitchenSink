package szaq.lcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author malczyk
 *
 */
@Data
@AllArgsConstructor
public class Properties {

	/**
	 * number of copies ?
	 */
	private int numerocity;

	/**
	 * numer of times it's been on a match set
	 */
	private int matchCount;

	/**
	 * numer of times it's been on a correct set
	 */
	private int correctCount;

	public double getAccuracy() {
		if (matchCount == 0) {
			return 0.0;
		}
		return correctCount / matchCount;
	}

	public void increaseMatchCount() {
		matchCount += 1;
	}

	public void increatesCorrectCount() {
		correctCount += 1;
	}

	public static Properties init() {
		return new Properties(0, 0, 0);
	}

}
