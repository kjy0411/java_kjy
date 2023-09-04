package kr.kh.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

	

}
