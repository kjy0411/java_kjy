package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;

	@Override
	public void postHandle(
		HttpServletRequest request,
		HttpServletResponse respose,
		Object handler,
		ModelAndView mv) {
		
		MemberVO user = (MemberVO)mv.getModel().get("user");
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			//�ڵ��α����� üũ�� ���
			if(user.isAutoLogin()) {
				//��Ű�� �����Ͽ� �ʿ��� ������ �ְ�, Ŭ���̾�Ʈ���� ����
				Cookie cookie = new Cookie("loginCookie", session.getId());
				cookie.setPath("/");
				int day = 7;
				int time = 60 * 60 * 24 * day;
				cookie.setMaxAge(time);
				respose.addCookie(cookie);
				//��Ű�� ���� �ʿ��� ������ DB���� �߰� 
				user.setMe_session_id(session.getId());
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
		}
	}

}