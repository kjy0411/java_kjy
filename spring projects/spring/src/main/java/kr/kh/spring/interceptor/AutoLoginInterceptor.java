package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("user");

		//�α����� �ȵǾ� ���� �� �ڵ� �α����� ���������� ���� 
		if(user == null) {
			//loginCookie ������ ������
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			//loginCookie�� null�� �ƴϸ� =>������ �ڵ��α����� üũ������  
			if(cookie != null) {
				//��Ű�� �ִ� ���� ������ ��ġ�ϴ� ȸ�� ������ ������ 
				String session_id = cookie.getValue();
				user = memberService.getMemberBySession(session_id);
				//ȸ�� ������ ������ ���ǿ� ����(�ڵ��α��� ����)
				if(user != null) {
					session.setAttribute("user", user);
				}
			}
		}

		return true;
	}

}