package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	private BoardDAO boardDao;
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	public List<BoardVO> getBoardList() {
		//매개변수체크(매개변수가 없으므로 생략)
		List<BoardVO> list = boardDao.selectBoardList();
		return list;
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		//매개변수체크
		if(bo_num == null) {
			return null;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.selectBoard(bo_num);
		//가져오면 반환
		return board;
	}

	@Override
	public void updateViews(Integer bo_num) {
		//매개변수 체크
		if(bo_num == null) {
			return;
		}
		//다오에게 게시글 번호를 주면서 조회수를 1증가시키라고 요청
		boardDao.updateViews(bo_num);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		return res;
	}

	@Override
	public boolean update(BoardVO board, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		boolean res = boardDao.updateBoard(board);
		return res;
	}

	@Override
	public boolean delete(Integer bo_num, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(bo_num == null) {
			return false;
		}
		BoardVO dbBoard = boardDao.selectBoard(bo_num);
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		boolean res = boardDao.deleteBoard(bo_num);
		return res;
	}
}
