package io.playdata.service;

import java.util.List;

import io.playdata.domain.Board;
/* interface설정. method는 미완성. -> implements로 받는 class에서 해당 메소드를 완성시켜야 함 */
public interface BoardService {

	List<Board> getBoardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}