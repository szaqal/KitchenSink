package szaq.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SettingService {
	

	@Value("${testKey}")
	private String value;
	
	public String getValue() {
		return value;
	}
}
