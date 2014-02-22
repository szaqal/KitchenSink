package szaq.spring.boot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@RestController
public class HelloWorldController {

	@RequestMapping("/")
	public String hello() {
		return "HELLO";
	}
}
