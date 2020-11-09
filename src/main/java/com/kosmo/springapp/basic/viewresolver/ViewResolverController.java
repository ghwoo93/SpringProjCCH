package com.kosmo.springapp.basic.viewresolver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


//컨트롤러 클래스]
@Controller
public class ViewResolverController {
	
	//컨트롤러 메소드]
	/*
	@RequestMapping("/ViewResolver/ViewResolver.do")
	public String execute(Model model) {
		//데이타 저장]
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		model.addAttribute("message", dateFormat.format(new Date()));
		//뷰 정보 반환]
		//접두어(/WEB-INF/views/)와 접미어(.jsp)를 뺀 논리적인 이름만 반환
		//1. .jsp페이로 forward(디폴트)
		//return "viewresolver03/ViewResolver";
		//2. .do로 forward
		//아래 처럼 뷰정보 반환시 접두어 접미어가 붙어서 404에러 발생
		///WEB-INF/views/ViewResolver/NotJSP.do.jsp
		//return "/ViewResolver/NotJSP.do";
		
		
		  ※InternalResourceViewResolver를 통한 접두어 접미어에 영향을 안받으려면 return 시 "forward:" 이나
		  "redirect:"나 단,"redirect:"는 "redirect:jsp페이지 경로가 아닌 Context경로" 혹은
		  ModelAndView객체(View객체)로 반환하면 된다.
		 
		//접두어/접미어 영향 받지 않기-주로 .do로 이동시에 적용한다
		//[forward 로 이동시]
		//1. .jsp페이로 forward(디폴트)
		//return "forward:/WEB-INF/views/viewresolver03/ViewResolver.jsp";
		//2. .do로 forward
		//return "forward:/ViewResolver/NotJSP.do";
		//[redirect로 이동시]
		//※리다이렉트시 쿼리스트링으로 전달된다
		
		//1. .jsp페이로 redirect-/WEB-INF밑에 있는 JSP파일을 직접 URL로 요청한거와 같다 그래서 404에러
		//return "redirect:/WEB-INF/views/viewresolver03/ViewResolver.jsp";
		//2. .do로 redirect
		return "redirect:/ViewResolver/NotJSP.do";
	
	}*/
	@RequestMapping("/ViewResolver/ViewResolver.do")
	public ModelAndView execute(Model model) {
		//데이타 저장]
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		model.addAttribute("message", dateFormat.format(new Date()));
	
		return new ModelAndView(new RedirectView("/ViewResolver/NotJSP.do", true));
	}/////////////execute	
	//컨트롤러 메소드-execute()메소드에서 포워드를 받는 메소드]
	@RequestMapping("/ViewResolver/NotJSP.do")
	public String notjsp(@RequestParam String message) throws UnsupportedEncodingException {
		System.out.println("파라미터:"+message);
		return "viewresolver03/ViewResolver";//forward
	}
}//////////////ViewResolverController
