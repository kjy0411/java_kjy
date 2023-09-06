package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GuestInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		//세션에 회원 정보가 없으면 메인 페이지로 이동
		//Object 존재 유무만 판단하며 정보를 빼내어 사용할 수 없다
		Object user = request.getSession().getAttribute("user");
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		//로그인을 했으면
		if(user != null) {
			//메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/");
			//기존에 가려던 URL은 방문하지 않고 메인으로 이동
			return false;
		}
		//로그인 했으면 기존에 가려던 URL을 방문해서 작업
		return true;
	}
}
