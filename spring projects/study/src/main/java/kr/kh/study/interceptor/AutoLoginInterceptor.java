package kr.kh.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//�̹� �α��εǾ� ������ �ǳʶ�
		HttpSession session = request.getSession();
		//�θ�Ŭ���� ��ü(Object)�� �ڽ� Ŭ����(MemberVO) ��ü�� ����ȯ
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			return true;
		}
		//�α��εǾ����� ������ ��Ⱑ �ִ��� Ȯ��
		Cookie cookie = WebUtils.getCookie(request, "lc");
		//��Ⱑ ������ �ǳʶ�(�ڵ��α��� X)
		if(cookie == null) {
			return true;
		}
		user = memberService.getMemberBySession(cookie.getValue());
		if(user != null) {
			session.setAttribute("user", user);
		}
		return true;
	}
}
