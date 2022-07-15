package io.playdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.playdata.dao.BoardRepository;
import io.playdata.domain.Board;

/* BoardService interface에서 implements로 받아와서 해당 메소드를 완성. @Service annotation으로 실질적인 service역할 명시
 * BoardRepository의 singleton객체 사용. -> 여기로 넘어가서 추가 process 정보 확인 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;

	public List<Board> getBoardList(Board board) {
		return (List<Board>) boardRepo.findAll();
	}

	public void insertBoard(Board board) {
		System.out.println(board);
		boardRepo.save(board);
	}

	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}

	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();

		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}

}
