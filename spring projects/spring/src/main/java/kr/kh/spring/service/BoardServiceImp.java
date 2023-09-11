package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.controller.BoardController;
import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.util.UploadFileUtils;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		if(!boardDao.insertBoard(board)) {
			return false;
		}
		//÷�������� ���ε�
		if(files == null || files.length == 0) {
			return true;
		}
			//÷�������� ������ ���ε� �ϰ�, DB�� ����
		uploadFileAndInsert(files, board.getBo_num());	
		
		return true;
	}

	private void uploadFileAndInsert(MultipartFile[] files, int bo_num) {
		if(files == null || files.length == 0) {
			return;
		}
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			try {
				String fi_name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(bo_num, fi_name, file.getOriginalFilename());
				boardDao.insertFile(fileVo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardCount(cri);
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public void updateViews(Integer bo_num) {
		if(bo_num == null) {
			return;
		}
		boardDao.updateBoardViews(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MultipartFile[] files, Integer[] delFiles, MemberVO user) {
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		//�Խñ� ������ ������(�α����� ȸ���� �ۼ��ڰ� ������ Ȯ���ϱ� ����)
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//db�� �ش� �Խñ��� ���ų� �Խñ� �ۼ��ڿ� �α����� ȸ���� �ٸ����
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		if(!boardDao.updateBoard(board)){
			return false;
		}
		//÷������ ������Ʈ
		//�߰��� ÷�������� ������ ���ε� �� DB�� �߰�
		uploadFileAndInsert(files, board.getBo_num());
		//������ ÷�������� �������� ���� �� DB���� ����
		deleteFile(delFiles);
		return true;
	}

	private void deleteFile(Integer[] delFiles) {
		if(delFiles == null || delFiles.length == 0) {
			return;
		}
		for(Integer num : delFiles) {
			if(num == null) {
				continue;
			}
			//÷������ ������ ������
			FileVO fileVo = boardDao.selectFile(num);
			if(fileVo == null) {
				continue;
			}
			UploadFileUtils.deleteFile(uploadPath, fileVo.getFi_name());
			//DB���� ����
			boardDao.deleteFile(num);
		}
	}

	@Override
	public boolean deleteBoard(Integer bo_num, MemberVO user) {
		if(bo_num == null || user == null) {
			return false;
		}
		BoardVO board = boardDao.selectBoard(bo_num);
		//���� �Խñ��̰ų� �ۼ��ڰ� �ƴϸ�
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//÷������ ����
		List<FileVO> fileList = board.getFileVoList();
		deleteFile(fileList);
		//�Խñ� ����
		boardDao.deleteBoard(bo_num);
		return true;
	}

	private void deleteFile(List<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0){
			return;
		}
		Integer [] nums = new Integer[fileList.size()];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = fileList.get(i).getFi_num();
		}
		deleteFile(nums);
	}

	@Override
	public int like(LikeVO likeVo) {
		if(likeVo == null || likeVo.getLi_me_id() == null) {
			return -100;
		}
		//���� ��õ ������ ������(�Խñ� ��ȣ�� ���̵�)
		LikeVO dbLikeVo = boardDao.selectLike(likeVo.getLi_bo_num(), likeVo.getLi_me_id());
		
		
		//���� ��õ ������ ������
		if(dbLikeVo == null) {
			//�߰�
			boardDao.insertLike(likeVo);
		}else {	//������
			//db�� �ִ� ��õ���¿� ȭ�鿡 ���� ��õ ���°� ������ => ���
			if(dbLikeVo.getLi_state() == likeVo.getLi_state()) {
				likeVo.setLi_state(0);
			}
			//������Ʈ
			boardDao.updateLike(likeVo);
		}		
		boardDao.updateBoardLike(likeVo.getLi_bo_num());
		return likeVo.getLi_state();
	}

	@Override
	public LikeVO getBoardLike(Integer bo_num, MemberVO user) {
		if(bo_num == null || user == null) {
			return null;
		}
		return boardDao.selectLike(bo_num, user.getMe_id());
	}

	@Override
	public List<BoardTypeVO> getboardTypeList() {
		return boardDao.selectBoardTypeList();
	}

	@Override
	public boolean insertBoardType(BoardTypeVO boardType) {
		if(boardType == null || boardType.getBt_title() == null || boardType.getBt_authority() == null) {
			return false;
		}
		//�Խ��Ǹ��� �ߺ��Ǵ°� �����ϱ� ����
		try {
			boolean res = boardDao.insertBoardType(boardType);
			if(!res) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		switch (boardType.getBt_authority()) {
		case "USER":
			boardDao.insertBoardAuthority(boardType.getBt_num(), "USER");
		case "ADMIN":
			boardDao.insertBoardAuthority(boardType.getBt_num(), "ADMIN");
			break;
		}
		return true;
	}

	@Override
	public boolean deleteBoardType(BoardTypeVO boardType) {
		if(boardType == null) {
			return false;
		}
		//��ϵ� �Խñ��� �ִ��� Ȯ��
		int count = boardDao.selectBoardCountByBoardType(boardType.getBt_num());
		//������ ���� ����
		if(count != 0) {
			return false;
		}
		//��ϵ� �Խ��� Ÿ���� � �ִ��� Ȯ��
		int btCount = boardDao.selectBoardTypeCount();
		
		//1�� ������ ���� ����
		if(btCount == 1) {
			return false;
		}
		//�Խ��� Ÿ���� ����
		return boardDao.deleteBoardType(boardType.getBt_num());
	}

	
	@Override
	public boolean updateBoardType(BoardTypeVO boardType) {
		if(boardType == null || boardType.getBt_title() == null) {
			return false;
		}
		System.out.println(boardType);
		//DB�󿡼� bt_title�� unique ������ �Ͽ� �̸��� �ߺ��Ǹ� ������ �߻��ϴ°��� �̿�
		try {
			return boardDao.updateBoardType(boardType);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<BoardTypeVO> getBoardTypeList(MemberVO user) {
		if(user == null || user.getMe_role() == null) {
			return null;
		}
		return boardDao.selectBoardTypeListByRole(user.getMe_role());
	}
}
