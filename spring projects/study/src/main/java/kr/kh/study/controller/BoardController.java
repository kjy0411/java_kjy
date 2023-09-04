package kr.kh.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/board/list")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model, Integer bo_num) {
		//�Խñ� �������� ���� ���񽺿��� �Խñ� ��ȣ�� �ָ鼭 ��ȸ���� 1 �����϶�� ��û
		boardService.updateViews(bo_num);
		//���񽺿��� �Խñ� ��ȣ�� �ָ鼭 �Խñ��� ��������� ��û
		BoardVO board = boardService.getBoard(bo_num);
		//������ �Խñ��� ȭ�鿡 ����
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@GetMapping("/board/insert")
	public String boardInsert() {		
		return "/board/insert";
	}
	
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");

		boolean res = boardService.insertBoard(board, user);
		if(res) {
			model.addAttribute("msg", "�Խñ��� ����߽��ϴ�.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "�Խñ��� ������� ���߽��ϴ�.");
			model.addAttribute("url", "/board/insert");
		}
		
		return "/util/message";
	}
	
}
