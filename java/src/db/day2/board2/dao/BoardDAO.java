package db.day2.board2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day2.board2.vo.BoardVO;

public interface BoardDAO {

	int insertBoard(@Param("title")String title, @Param("id")String id);

	ArrayList<BoardVO> printBoard(String id);

	int updateBoard(@Param("num")int num, @Param("title")String title);

	int deleteBoard(int num);

	ArrayList<BoardVO> printBoardList();

}
