package szaqal.forkjoin.generators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.google.common.base.Preconditions;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
public abstract class AbstractItemGenerator<T> implements ItemGenerator<T> {
	
	protected static final Random RANDOM = new Random(System.currentTimeMillis()); 
	
	
	protected final List<String> loadAll(String fileName) {
		Preconditions.checkNotNull(fileName, "Filename can't be null");
		List<String> result = new ArrayList<>();
		try {
			InputStream is = getClass().getResourceAsStream("/data/"+fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while( (line = reader.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected final T randomGet(List<T> items) {
		return items.get(RANDOM.nextInt(items.size()));
	}
	
}
