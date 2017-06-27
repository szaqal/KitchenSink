package szaqal.springvaadin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author malczyk.pawel@gmail.com
 * 
 */
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		String message = helloService.getMvcText();
		return new ModelAndView("hello", "message", message);
	}
}
