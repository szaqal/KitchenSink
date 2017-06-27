package szaqal.springvaadin.demo;

import org.springframework.stereotype.Component;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Component
public class HelloService {


    public HelloService() {
    }

    public String getVaadinText() {
        return "HELLO VAADIN";
    }
    
    public String getMvcText() {
    	return "HELLO SPRING MVC";
    }
}
