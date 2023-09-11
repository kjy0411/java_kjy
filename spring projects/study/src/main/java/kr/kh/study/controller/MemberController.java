package kr.kh.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/signup")
	public String memberSignup() {
		return "member/signup";
	}
	
	@PostMapping("/member/signup")
	public String memberSignupPost(MemberVO member, Model model) {
		String msg, url;
		
		if(memberService.signup(member)) {
			msg = "회원가입 성공!";
			url = "/";
		}else {
			msg = "회원가입 실패!";
			url = "/member/signup";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "util/message";
	}
	
	@GetMapping("/member/login")
	public String memberLogin() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String memberLoginPost(MemberVO member, Model model) {
		String msg, url;
		MemberVO user = memberService.login(member);
		
		if(user != null) {
			msg = "로그인 성공!";
			url = "/";
			user.setAutoLogin(member.isAutoLogin());
		}else {
			msg = "로그인 실패!";
			url = "/member/login";
		}
		
		model.addAttribute("user", user);
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "util/message";
	}
	
	@GetMapping("/member/logout")
	public String memberLogoutPost(HttpServletRequest request, Model model) {
		String msg = null;
		String url = "/";
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		user.setMe_session_limit(null);
		memberService.updateMemberSession(user);
		if(user != null) {
			session.removeAttribute("user");
			msg = "로그아웃 성공!";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "util/message";
	}
}