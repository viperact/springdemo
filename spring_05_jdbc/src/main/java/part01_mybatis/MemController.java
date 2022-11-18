package part01_mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8090/myapp/list.do

@Controller
public class MemController {
	
	private MemDAO memDAO;
	
	public MemController() {
		
	}

	public void setMemDAO(MemDAO memDAO) {
		this.memDAO = memDAO;
	}
	
	@RequestMapping(value = "list.do")
	public ModelAndView process(ModelAndView mav) {
		mav.addObject("list", memDAO.list());
		mav.setViewName("part01/list");
		return mav;
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertForm() {
		return "part01/insert";
	}
	
	
}//end class







