package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailsController {

	@RequestMapping("/details.do")
	public String execute() {
		return "details";
	}//end execute()
	
}//end class
