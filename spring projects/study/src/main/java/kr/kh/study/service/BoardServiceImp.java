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
}
