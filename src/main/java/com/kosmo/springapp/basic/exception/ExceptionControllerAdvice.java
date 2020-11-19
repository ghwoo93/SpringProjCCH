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
		System.out.println("exception()메소드");
		model.addAttribute("errorMsg","오류발생-업체에 연락하세요");
		//뷰정보 반환]
		return "exception12/Exception";
	}/////////////////
	
	
	
}
