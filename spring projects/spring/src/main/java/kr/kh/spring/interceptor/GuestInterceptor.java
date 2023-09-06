package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GuestInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		//���ǿ� ȸ�� ������ ������ ���� �������� �̵�
		//Object ���� ������ �Ǵ��ϸ� ������ ������ ����� �� ����
		Object user = request.getSession().getAttribute("user");
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		//�α����� ������
		if(user != null) {
			//������������ �̵�
			response.sendRedirect(request.getContextPath()+"/");
			//������ ������ URL�� �湮���� �ʰ� �������� �̵�
			return false;
		}
		//�α��� ������ ������ ������ URL�� �湮�ؼ� �۾�
		return true;
	}
}
