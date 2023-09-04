package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList() {
		//매개변수체크(매개변수가 없으므로 생략)
		List<BoardVO> list = boardDao.selectBoardList();
		return list;
	}

}
