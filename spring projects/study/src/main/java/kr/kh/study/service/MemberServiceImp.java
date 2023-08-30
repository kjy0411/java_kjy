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
		//������ �Ű������� ��������� ����ó��
		if(member == null
				|| member.getMe_id() == null
				|| member.getMe_pw() == null
				|| member.getMe_email() == null) {
			return false;
		}
		//��ȿ���˻�� ���ʿ�
		if(!checkRegexMember(member)) {
			return false;
		}
		//�ٿ����� �����ͺ��̽��� ���� ���̵� �����ϴ��� Ȯ���ϵ��� �ϰ� ������ ������ ������
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//������ ������ ������ ���̵� �ߺ�, ����ó��
		if(dbMember != null) {
			return false;
		}
		//��й�ȣ ��ȣȭ
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		//�ٿ����� ��������� �Է��ϵ��� ��Ŵ
		//�����ϸ� ȸ������ ����
		return memberDao.insertMember(member);
	}

	private boolean checkRegexMember(MemberVO member) {
		//�ʿ��ϸ� ����
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