package part02;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import model.MemDAO;
import model.MemDTO;

public class ServiceImp implements Service {

	private MemDAO memDAO;

	public ServiceImp() {

	}

	public void setMemDAO(MemDAO memDAO) {
		this.memDAO = memDAO;
	}


	@Override
	public void insertProcess() {
		memDAO.insertMethod(new MemDTO(49, "용팔이", 50, "경기"));
		memDAO.insertMethod(new MemDTO(50, "유대위", 50, "대전"));
	}// end insertProcess

}// end class
