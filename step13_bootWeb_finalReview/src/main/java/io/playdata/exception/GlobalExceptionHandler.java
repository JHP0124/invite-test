package io.playdata.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 전역에 있는 controller에 대한 예외처리를 하기 위한 설정 */
@ControllerAdvice
public class GlobalExceptionHandler {
	/* @ExceptionHandler같은 경우는 @Controller, @RestController가 적용된 Bean내에서 발생하는 예외를 잡아서 하나의 메서드에서 처리해주는 기능
	 * @ExceptionHandler를 설정하면 해당 controller에만 적용이 되는데 이를 해결하기 위해서 @ControllerAdvice 설정으로 전역에 있는 controller에 대해 예외처리를 하게 해줌. */
	@ExceptionHandler(BoardException.class)
	public String handleCustomException(BoardException exception, Model model) {
		System.out.println("GlobalExceptionHandler의 handleCustomException()********");
		
		model.addAttribute("exception", exception);
		return "/errors/boardError";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		System.out.println("GlobalExceptionHandler의 handleException()**********");
		
		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}
}
