package kr.kh.spring.service;

import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		
		//���̵� �ߺ� Ȯ��
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//�����Ϸ��� ���̵� �̹� ���Ե� ���`
		if(dbMember != null) {
			return false;
		}
		//���, �̸��� nullüũ + ��ȿ�� �˻�
		//���̵�� �������� �����ϸ� ����,���ڷ� �̷������ 6~15��
		String idRegex = "^[a-zA-Z][a-zA-Z0-9]{5,14}$";
		//����� ����,����,!@#$%�� �̷������ 6~15��
		String pwRegex = "^[a-zA-Z0-9!@#$%]{6,15}$";
		
		//���̵� ��ȿ���� ���� ������
		if(!Pattern.matches(idRegex, member.getMe_id())) {
			return false;
		}
		//����� ��ȿ���� ���� ������
		if(!Pattern.matches(pwRegex, member.getMe_pw())) {
			return false;
		}
		
		//��� ��ȣȭ
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		//ȸ������
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//���Ե� ���̵� �ƴϸ�
		if(dbMember == null) {
			return null;
		}
		//���Ȯ��
		//matches(��ȣȭ �ȵ� ���ڿ�, ��ȣȭ�� ���ڿ�)
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw())) {
			return dbMember;
		}
		return null;
	}
	
	@Override
	public void updateMemberSession(MemberVO user) {
		if(user == null) {
			return;
		}
		memberDao.updateMemberSession(user);
	}

	@Override
	public MemberVO getMemberBySession(String session_id) {
		return memberDao.selectMemberBySession(session_id);
	}

	@Override
	public boolean sendMail(String to, String title, String contents) {
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom("rhdwkrghf@gmail.com");  // �����»�� �����ϰų� �ϸ� �����۵��� ����
	        messageHelper.setTo(to);     // �޴»�� �̸���
	        messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	        messageHelper.setText(contents, true);  // ���� ����

	        mailSender.send(message);
	        return true;
	    } catch(Exception e){
	        System.out.println(e);
	    }
		return false;
	}

	@Override
	public Object checkID(String id) {
		return memberDao.selectMember(id) == null;
	}


}