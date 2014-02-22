package szaq.spring.boot.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import szaq.spring.boot.ApplicationSetup;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@RestController
public class MainController {

	@Resource
	private ApplicationSetup applicationSetup;
	
	@RequestMapping("/")
	public String showEnv() {
		return applicationSetup.toString();
	}
}
