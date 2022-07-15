package io.playdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.playdata.domain.Board;
import io.playdata.domain.Member;
import io.playdata.exception.BoardNotFoundException;
import io.playdata.service.BoardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@SessionAttributes("member")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@ApiIgnore
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
	/* 기본타입으로 받을 때는 @ModelAttribute("member")를 사용해야 하지만 여기서는 기본 타입이 아니기 때문에 지워서 실행해도 문제가 없었음. 
	 * request나 session을 사용할 떄는 Model 객체를 불러와서 사용하는 것이 합당. */
	@ApiOperation(value="게시판 불러오기", notes="API 설명 : 게시판 불러오기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		
		if (member.getId() == null) {
			return "redirect:login.html";
		}

		List<Board> boardList = boardService.getBoardList(board);

		System.out.println(boardList);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@ApiOperation(value="게시글 보기", notes="API 설명 : 게시글 보기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		return "insertBoard";
	}
	
	@ApiOperation(value="게시글 입력", notes="API 설명 : 게시글 입력")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}
		boardService.insertBoard(board);
		System.out.println("-------insertBoard----------------------");
		return "redirect:getBoardList";
	}
	
	@ApiOperation(value="게시글 가져오기", notes="API 설명 : 게시글 가져오기")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@ApiOperation(value="게시글 수정", notes="API 설명 : 게시글 수정")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@ApiOperation(value="게시글 삭제", notes="API 설명 : 게시글 삭제")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null) {
			return "redirect:login";
		}

		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}

}
