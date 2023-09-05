package kr.kh.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.pagination.PageMaker;
import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.FileVO;
import kr.kh.study.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/board/list")
	public String boardList(Model model, Criteria cri) {
		cri.setPerPageNum(2);
		List<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardtotalCount();
		
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model, Integer bo_num) {
		//게시글 가져오기 전에 서비스에게 게시글 번호를 주면서 조회수를 1 증가하라고 요청
		boardService.updateViews(bo_num);
		//서비스에게 게시글 번호를 주면서 게시글을 가져오라고 요청
		BoardVO board = boardService.getBoard(bo_num);
		//서비스에게 게시글 번호를 주면서 첨부파일 리스트를 가져오라고 요청
		List<FileVO> fileList = boardService.getFileList(bo_num);
		//가져온 게시글과 첨부파일 리스트를 화면에 전송
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		return "/board/detail";
	}
	
	@GetMapping("/board/insert")
	public String boardInsert() {		
		return "/board/insert";
	}
	
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, HttpSession session, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");

		boolean res = boardService.insertBoard(board, user, files);
		if(res) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		
		return "/util/message";
	}
	
	@GetMapping("/board/update")
	public String boardUpdate(Model model, Integer bo_num) {		
		BoardVO board = boardService.getBoard(bo_num);
		List<FileVO> fileList = boardService.getFileList(bo_num);
		
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		return "/board/update";
	}
	
	@PostMapping("/board/update")
	public String boardUpdatePost(Model model, BoardVO board, HttpSession session, MultipartFile[] files, int[] delNums) {
		System.out.println(delNums);
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.update(board,user,files,delNums);
		if(res) {
			model.addAttribute("msg", "게시글을 수정했습니다.");
		}else {
			model.addAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		model.addAttribute("url", "/board/detail?bo_num="+board.getBo_num());
		return "/util/message";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Model model, Integer bo_num, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.delete(bo_num, user);
		if(res) {
			model.addAttribute("msg", "게시글을 삭제했습니다.");
		}else {
			model.addAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		model.addAttribute("url", "/board/list");			
		return "/util/message";
	}
}
