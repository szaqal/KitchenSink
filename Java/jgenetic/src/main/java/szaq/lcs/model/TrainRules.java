package szaq.lcs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Training rules having all attributes set.
 * @author malczyk
 *
 */
@Data
@AllArgsConstructor
public class TrainRules {
	
	/**
	 * List of training rules
	 */
	private List<Classifier> trainingInstances;
	
	@Override
	public String toString() {
		return io.vavr.collection.List.of(trainingInstances).mkString(",");
	}
}
