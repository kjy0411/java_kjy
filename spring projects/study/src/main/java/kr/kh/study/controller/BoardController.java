package kr.kh.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;

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
}
