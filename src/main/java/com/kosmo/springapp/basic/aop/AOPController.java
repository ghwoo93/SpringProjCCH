package com.kosmo.springapp.basic.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOPController {

	@Resource(name="targetObject")
	private TargetClass target;
	
	@RequestMapping("/AOP/AOP.do")
	public String execute(Model model) {
		//대상 클래스의 핵심 메소드 호출]
		long total=target.getTotal();
		model.addAttribute("total",total);
		return "aop14/AOP";
	}
}
