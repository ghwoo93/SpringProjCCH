package com.kosmo.springapp.basic.exception;
/*
 * @ControllerAdvice 를 통해 모든 컨트롤러에서 발생하는 예외 처리
 * @ExceptionHandler 를 통해 발생하는 예외 종류에 따른 메소드 정의
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//개발시는 아래 주석
//@ControllerAdvice
public class ExceptionControllerAdvice {
	
	
	@ExceptionHandler({Exception.class})
	public String exception(Exception e,Model model) {
		model.addAttribute("errors",String.format("<h4>담당자에게 연락하세요</h4><span style='color:red;font-weight:bold'>%s</span>",e.getMessage()));
		//뷰정보 반환]
		return "exception12/Errors";
	}/////////////////
	
	
	
}
