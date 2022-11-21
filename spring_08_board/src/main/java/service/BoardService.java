package service;

import java.util.List;

import dto.BoardDTO;
import dto.PageDTO;

public interface BoardService {
	public int countProcess();
	public List<BoardDTO> listProcess(PageDTO pv);
	public void insertProcess(BoardDTO dto);
	public BoardDTO contentProcess(int num);
	public void reStepProcess(BoardDTO dto);
	public BoardDTO updateProcess(BoardDTO dto, String urlpath);
	public void deleteProcess(int num, String urlpath);
	public String fileSelectprocess(int num);
}
