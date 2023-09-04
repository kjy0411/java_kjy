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
		//�Ű�����üũ(�Ű������� �����Ƿ� ����)
		List<BoardVO> list = boardDao.selectBoardList();
		return list;
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		//�Ű�����üũ
		if(bo_num == null) {
			return null;
		}
		//�ٿ����� �Խñ� ��ȣ�� �ָ鼭 �Խñ��� ��������� ��Ŵ
		BoardVO board = boardDao.selectBoard(bo_num);
		//�������� ��ȯ
		return board;
	}

	@Override
	public void updateViews(Integer bo_num) {
		//�Ű����� üũ
		if(bo_num == null) {
			return;
		}
		//�ٿ����� �Խñ� ��ȣ�� �ָ鼭 ��ȸ���� 1������Ű��� ��û
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
		
		MemberVO dbMember = memberDao.selectMember(user.getMe_id());
		if(dbMember == null) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		return res;
	}
}
