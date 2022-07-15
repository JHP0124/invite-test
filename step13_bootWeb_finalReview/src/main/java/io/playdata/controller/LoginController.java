package io.playdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import io.playdata.domain.Member;
import io.playdata.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@SessionAttributes("member")
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;

	/*
	 * spring에서의 Model 객체
	 * - 순수하게 JSP servlet으로 web application을 만들 때에는 보통 request나 session 내장 객체에 담아 정보를 넘겨주었지만
	 * 	Spring에서는 Model이라는 개념을 사용. request.setAttribute()와 비슷한 역할.
	 * 	
	 *  controller로 넘어오는 parameter 값이 getter/setter를 가진 클래스 객체의 멤버 변수와 개수가 같으면 자동으로 객체를 생성
	 *  기본타입의 객체를 받아올 때에는 메소드 내 parameter앞에다가 @ModelAttribute("받아오는값")을 설정해 주면 된다.
	 */
	@ApiOperation(value="로그인", notes="API 설명 : 로그인")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);

		if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "forward:getBoardList";
		} else {
			return "redirect:login.html";
		}
	}
	
	/* SessionStatus 객체의 setComplete() 메서드를 사용해 해당 session에 저장된 정보를 clear함. */
	@ApiOperation(value="로그 아웃", notes="API 설명 : 로그 아웃")
	@ApiResponses({
		@ApiResponse(code = 200, message = "DB에 있는 데이터와 일치. 로그인 성공"),
		@ApiResponse(code = 500, message = "500 에러 발생시 출력 메시지, 가령 Internal Server Error 발생"),
		@ApiResponse(code = 404, message = "404 에러 발생시 출력 메시지, Not found....?")
	})
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}

}
