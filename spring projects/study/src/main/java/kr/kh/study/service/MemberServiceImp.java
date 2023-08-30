package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;


@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		//가져온 매개변수가 비어있으면 실패처리
		if(member == null
				|| member.getMe_id() == null
				|| member.getMe_pw() == null
				|| member.getMe_email() == null) {
			return false;
		}
		//유효성검사는 위쪽에
		if(!checkRegexMember(member)) {
			return false;
		}
		//다오에게 데이터베이스에 같은 아이디가 존재하는지 확인하도록 하고 있으면 정보를 가져옴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//가져온 정보가 있으면 아이디 중복, 실패처리
		if(dbMember != null) {
			return false;
		}
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		//다오에게 멤버정보를 입력하도록 시킴
		//성공하면 회원가입 성공
		return memberDao.insertMember(member);
	}

	private boolean checkRegexMember(MemberVO member) {
		//필요하면 구현
		return true;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null) {
			return null;
		}
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())){
			return user;
		}
		return null;
	}


}