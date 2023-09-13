package kr.kh.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.CommentVO;

public interface CommentDAO {

	boolean insertCommetn(@Param("comment")CommentVO comment);

	List<CommentVO> selectCommentList(@Param("bo_num")int bo_num, @Param("cri")Criteria cri);

	int selectCommentCount(@Param("bo_num")int bo_num);

	boolean deleteComment(@Param("co_num")int co_num);

}