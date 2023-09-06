package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.LikeVO;
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
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert(Model model, Integer bo_ori_num) {
		model.addAttribute("bo_ori_num", bo_ori_num == null ? 0 : bo_ori_num);
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user, files)) {
			msg = new Message("/board/list", "�Խñ��� ����߽��ϴ�.");
		}else {
			msg = new Message("/board/list", "�Խñ��� ������� ���߽��ϴ�.");
		}
		model.addAttribute("msg",msg);
		return "message";
	}
	@GetMapping("/detail")
	public String deatil(Model model, Integer bo_num, Criteria cri, HttpSession session) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.getBoard(bo_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		LikeVO like = boardService.getBoardLike(bo_num, user);
		model.addAttribute("board", board);
		model.addAttribute("cri", cri);
		model.addAttribute("like", like);
		return "/board/detail";
	}
	@GetMapping("/update")
	public String update(Model model, Integer bo_num, HttpSession session) {
		BoardVO board = boardService.getBoard(bo_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || board == null || !user.getMe_id().equals(board.getBo_me_id())) {
			Message msg = new Message("/board/list", "�߸��� �����Դϴ�.");
			model.addAttribute("msg", msg);
			return "message";
		}
		model.addAttribute("board", board);
		return "/board/update";
	}
	@PostMapping("/update")
	public String updatePost(Model model, BoardVO board, MultipartFile[] files, Integer[] delFiles, HttpSession session) {
		Message msg;
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(boardService.updateBoard(board, files, delFiles, user)) {
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "�Խñ��� �����߽��ϴ�.");
		}else {
			msg = new Message("/board/update?bo_num="+board.getBo_num(), "�Խñ��� �������� ���߽��ϴ�.");			
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	@GetMapping("/delete")
	public String delete(Model model, HttpSession session, Integer bo_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.deleteBoard(bo_num, user)) {
			msg = new Message("/board/list", "�Խñ��� �����߽��ϴ�.");
		}else {
			msg = new Message("/board/list", "�߸��� �����Դϴ�.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@ResponseBody
	@PostMapping("/like")
	public Map<String, Object> ajaxTest(@RequestBody LikeVO likeVo){
		Map<String, Object> map = new HashMap<String, Object>();
		//��õ :1, ����õ : -1, ��� : 0
		int res = boardService.like(likeVo);
		BoardVO board = boardService.getBoard(likeVo.getLi_bo_num());
		map.put("res", res);
		map.put("board", board);
		return map;
	}
}
