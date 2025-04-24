package szaqal.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Controller
public class AuthorizedController {

	@RequestMapping("/authorized")
	public String getView() {
		return "authorized";
	}
}
