package com.kosmo.springapp.basic.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {
	
	//방법1]서블릿 API사용으로 요청헤더값 알아내기
//	@RequestMapping("/Annotation/RequestHeader.do")
//	public String exec(HttpServletRequest req) {
//		String referer=req.getHeader("referer");
//		//리퀘스트 영역에 저장]
//		req.setAttribute("referer",referer);
//		//뷰정보 반환]
//		return "annotation06/Annotation";
//	}/////////////////
	//방법2]서블릿 API 미 사용,어노테이션 사용으로 요청헤더값 알아내기
	@RequestMapping("/Annotation/RequestHeader.do")
	public String exec(@RequestHeader(value = "referer",
	required = false,defaultValue = "헤더명이 존재하지 않아요") String referer,
			Model model) {
		//데이타 저장]
		model.addAttribute("referer",referer);
		//뷰정보 반환]
		return "annotation06/Annotation";
	}
}////////////////
