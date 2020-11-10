package com.kosmo.springapp.basic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Autowired 어노테이션] type->id->qualifier
 * -속성,세터,생성자에 붙일 수 있다
 * -type기반
 * -만약 주입하고자하는 
 *  객체가 없다면
 *  와이어링을 못함으로 예외 발생
 *  단,@Autowired의 required 속성을 false로 지정하면
 *  예외는 발생하지 않는다.
 *  
 * -설정 파일에 같은 타입의 객체(ID속성 미부여)를 여러개 
 *  등록후 주입시에는
 *  예외 발생 왜냐하면 프레임워크는 어느 객체를 주입해야 할지
 *  애매모호 함으로
 *  
 *  
 * -단, ID속성에 ID값부여시에는 프레임워크는 해당 ID값에
 *  일치하는 컨트롤러 클래스의 멤버변수(속성)를 찾아 주입해준다
 *  (여러개 인 경우도)
 *  
 * - 주입받을 클래스의 같은 타입의 속성이 여러개이고
 *   설정파일에 주입할 빈이 한개인 경우
 *   모든 속성에 똑같은 빈이 주입된다  즉 주소가 같다
 *   (type기반 임으로)(ID속성부여에 상관없이)
 *  
 * 
 * ※Autowired어노테이션으로 객체를 주입할때는
	 반드시 설정파일에 주입 하고자하는 빈은
	 하나만 등록 해야 한다.(ID속성 미 부여시에는)
	 단, 여러개 등록시에는 ID를 부여해서 구분하여라
	  
 * 
 */
//required=false]설정파일에 빈이 등록되 있으면
//와이어링 해주고,없으면 주입(와이어링)안해줌
@Controller
public class AutowiredController {
	
	//주로 속성에 붙이면 된다
	@Autowired(required = false)
	@Qualifier("fCommand")
	private Command fCommand;
	@Autowired
	@Qualifier("sCommand")
	private Command sCommand;
	/*
	//굳이 세터까지 만들 필요는 없다. 받은 가공할 필요가 없는 경우
	@Autowired(required = false)
	public void setfCommand(Command fCommand) {
		this.fCommand = fCommand;
	}*/

	@RequestMapping("/Annotation/Autowired.do")
	public String execute(Model model) {
		model.addAttribute("message", String.format("fCommand:%s,sCommand:%s", fCommand,sCommand));
		return "annotation06/Annotation";
	}
	
}
