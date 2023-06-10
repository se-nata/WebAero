package AeroControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/authorise")
public class SecurityController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginFail(Model uiModel) {
		
		return "authorise/authorise";
	}

}
