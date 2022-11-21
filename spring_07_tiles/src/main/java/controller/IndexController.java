package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myapp/index.do

@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String execute() {
		return "index"; // <definition name="index" template="/WEB-INF/views/template/layout.jsp">
	}//end execute()
	
}//end class
