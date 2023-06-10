package AeroControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/security")
public class LoginfaileController {
	
	@RequestMapping("/loginfail")
	public String loginFail(Model uiModel) {
		System.out.println("login failed");
		return "trip/list";
	}

}