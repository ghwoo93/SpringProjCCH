package com.kosmo.springapp.basic.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Resource어노테이션
 * - 속성과 세터에만 붙일 수 있다(생성자는 불가-@Autowired는 가능)
 * - @Autowired어노테이션과 같다.
 *   즉 자동으로 주입을 받는다
 *   단,와이어링 시 Name(id)기반.
 *   즉 @Resource(name="설정파일에 등록한 빈의 id값") 식으로
 *   와이어링
 *           ※설정파일이 아닌 어노테이션(@Service,@Repository등)을 통해 생성된 빈의 
 *     id는 지정하지 않는 경우 소문자로 시작하는 클래스명이 id가 된다
 * -@Autowired어노테이션과의 차이점:
 *  1.Name기반
 *  2.required 속성이 없음 즉 만약 설정파일(혹은 컨텍스트)에 
 *    와이어링 하고자 하는 빈이 등록이 되어 
 *    있지 않으면 예외 발생

 */


@Controller
public class ResourceController {	
	@Resource(name = "fCommand")
	private Command fCmd;
	@Resource(name = "sCommand")
	private Command sCmd;
	@RequestMapping("/Annotation/Resource.do")
	public String exec(Model model) {
		model.addAttribute("message", String.format("fCmd:%s<br/>sCmd:%s", fCmd,sCmd));
		return "annotation06/Annotation";
	}
	
}
