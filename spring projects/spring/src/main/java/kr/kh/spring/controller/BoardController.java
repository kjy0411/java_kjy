package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(2);
		//���� �������� �´� �Խñ��� �����;���
		List<BoardVO> list = boardService.getBoardList(cri);
		System.out.println(list);
		
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user)) {
			msg = new Message("/board/list", "�Խñ��� ����߽��ϴ�.");
		}else {
			msg = new Message("/board/list", "�Խñ��� ������� ���߽��ϴ�.");
		}
		model.addAttribute("msg",msg);
		return "message";
	}
}
