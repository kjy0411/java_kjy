package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.CommentDAO;
import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.CommentVO;


@Service
public class CommentServiceImp implements  CommentService{

	@Autowired
	private  CommentDAO  commentDao;

	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_me_id() == null || comment.getCo_contents() == null) {
			return false;
		}
		return commentDao.insertCommetn(comment);
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
	
	
}