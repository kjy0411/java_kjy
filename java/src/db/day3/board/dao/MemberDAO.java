package db.day3.board.dao;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("member")MemberVO member);
	
	//매개변수에 @Param을 붙였을 때와 아닐때의 차이를 보여주기 위한 insertMember와 기능이 같은 메서드
	void insertMember2(MemberVO member);

	void deleteMember(@Param("me_id")String me_id);

	void updateBoardCount(@Param("me_id")String bo_me_id);

	void updateBoardCount2(@Param("me_id")String bo_me_id);
	
}
