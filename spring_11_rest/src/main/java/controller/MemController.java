package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemDAO;
import dto.MemDTO;

//@RestController = @Controller + @ResponseBody

//@CrossOrigin("*") : 다른 모든 포트번호에대해 접근을 허용한다
//@CrossOrigin("http://localhost:3000") : "http://localhost:3000"의 특정포트번호에 대해 접근을 허용한다.

//@RestController
@Controller
public class MemController {
	private MemDAO dao;

	public MemController() {

	}

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	// http://localhost:8090/myapp/mem/list

	// RequestBody : json으로 넘어오는 객체를 java로 바꿔줌
	@ResponseBody
	// 검색기능은 무조건 GET
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<MemDTO> listMethod() {
		System.out.println("list");
		return dao.list();
	}// end listMethod

	// @PathVariable : url 경로에 변수를 넣어준다.
	// http://localhost:8090/myapp/mem/list/4 (mem talbe의 4번을 가지고와라)
	@ResponseBody
	@RequestMapping(value = "/list/{ss}", method = RequestMethod.GET)
	public MemDTO listMethod(@PathVariable("ss") int num) {
		return dao.list(num);
	}

	// 값을 두개 넘겨줄때
	// http://localhost:8090/myapp/mem/list/8/홍재수
	@ResponseBody
	@RequestMapping(value = "/list/{ss}/{name}", method = RequestMethod.GET)
	public MemDTO listMethod(@PathVariable("ss") int num, @PathVariable("name") String name) {
		return dao.list(new MemDTO(num, name));
	}

	// {"name":"홍길동", "age":30, "loc":"서울"}
	// http://localhost:8090/myapp/mem/insert

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> insertMethod(@RequestBody MemDTO dto) {
		ResponseEntity<String> entity = null;

		try {
			dao.register(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// {"num":10,"name":"Steven"}
	// http://localhost:8090/myapp/mem/update

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateMethod(@RequestBody MemDTO dto) {
		ResponseEntity<String> entity = null;

		try {
			dao.update(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//http://localhost:8090/myapp/mem/delete/8
	
	@RequestMapping(value = "/delete/{num}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletMethod(@PathVariable("num") int num){
		ResponseEntity<String> entity = null;
		
		try {
			dao.delete(num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	

}// end class













