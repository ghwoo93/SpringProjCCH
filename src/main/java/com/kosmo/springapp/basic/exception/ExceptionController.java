package com.kosmo.springapp.basic.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionController {
	
	/*방법1]스프링 API 미 사용.try~catch절로 예외처리
	※단,파일 업로드시 용량초과는 경우, 
	@ModelAttribute(value="속성명") 어노테이션으로
		세션영역에 저장된 속성을 읽어올때 저장된 속성이 없는 경우,
	@RequestParam int years일때 문자열을 입력하는 경우등
	try~catch절로 처리가 안됨으로 반드시 어노테이션으로 처리
    */
//	@RequestMapping("/Exception/Exception.do")
//	public String execute(@RequestParam String years,Model model) {
//		try {
//			//데이타 저장]
//			//int타입으로 받을때
//			//model.addAttribute("message", "[당신의 10년후 나이는 : "+(years+10)+"살]");
//			//String타입으로 받을때
//			model.addAttribute("message", "[당신의 10년후 나이는 : "+(Integer.parseInt(years)+10)+"살]");
//		}
//		catch(Exception e) {
//			model.addAttribute("message","나이는 숫자만...");
//		}
//		//뷰정보 반환]
//		return "exception12/Exception";
//	}////////////////
	//방법2]@ExceptionHandler 사용-예외처리하려는 모든 컨트롤러마다 작성해야함 즉 하나의 메서드에서 처리
	//@ExceptionHandler({ Exception1.class, Exception2.class,...}) 
	//@ExceptionHandler({NumberFormatException.class})
	//반환는 뷰 정보 즉 String가능
//	@ExceptionHandler({NumberFormatException.class})
//	public String error(Exception e,Model model) {
//		model.addAttribute("errorMsg","나이는 숫자라니까");
//		//뷰정보 반환]
//		return "exception12/Exception";
//	}/////////////////
	//방법3]모든 컨트롤러에서 발생하는 예외를 처리하기-위 error메소드 주석후 테스트
	//@ControllerAdvice 를 통해 모든 컨트롤러에서 발생하는 예외 처리 가능
	@RequestMapping("/Exception/Exception.do")
	public String execute(@RequestParam int years,Model model) {
		
		//데이타 저장]
		model.addAttribute("message", "[당신의 10년후 나이는 : "+(years+10)+"살]");
		//뷰정보 반환]
		return "exception12/Exception";
	}
	
}//////////////////////
