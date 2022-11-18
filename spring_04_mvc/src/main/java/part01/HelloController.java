package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/hello.htm

@Controller //controller annotation 설정
public class HelloController {
	public HelloController() {
		
	}
	
	@RequestMapping(value = "/hello.htm")
	public String search() {
		return "part01/hello";
	}
}
