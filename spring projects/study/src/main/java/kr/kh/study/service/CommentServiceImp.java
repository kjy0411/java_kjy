package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.dao.CommentDAO;
import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.CommentVO;


@Service
public class CommentServiceImp implements  CommentService{

	@Autowired
	CommentDAO  commentDao;
	
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_me_id() == null || comment.getCo_contents() == null) {
			return false;
		}
		boolean res = commentDao.insertCommetn(comment);
		if(!res) {
			return false;
		}
		//댓글 개수를 수정
		boardDao.updateBoardComment(comment.getCo_bo_num());			
		return res;
	}

	@Override
	public List<CommentVO> getCommetnList(int bo_num, Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return commentDao.selectCommentList(bo_num, cri);
	}

	@Override
	public int getTotalCount(int bo_num) {
		return commentDao.selectCommentCount(bo_num);
	}

	@Override
	public boolean deleteComment(CommentVO comment) {
		if(comment == null || (Integer)comment.getCo_num() == null || (Integer)comment.getCo_bo_num() == null) {
			return false;
		}
		boolean res = commentDao.deleteComment(comment.getCo_num());
		if(res) {
			boardDao.updateBoardComment(comment.getCo_bo_num());
		}
		return res;
	}

}