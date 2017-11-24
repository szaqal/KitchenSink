package szaq.lcs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrainRules {
	
	private List<Rule> rules;
	
	public String toString() {
		return io.vavr.collection.List.of(rules).mkString(",");
	}
}
