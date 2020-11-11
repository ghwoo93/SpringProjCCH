package com.kosmo.springapp.onememo.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;

/*
 * ※스프링 씨큐리티 사용시에는 
 *  기존방식의 로그인처리 및 로그인 여부 판단 그리고 로그아웃등
 *  모두 제거한다(.jsp 에서 혹은 .java에서)
 *  그리고 나서 스프링 씨큐리티에서 제공하는 API로 처리한다
 *  단,로그인처리 및 로그아웃은 스프링 씨큐리티에서 제공함으로
 *  로그인 판단 여부만 처리하면 된다.
 */

@SessionAttributes("id")//스프링 씨큐리티를 사용하지 않을때
@RequestMapping("/OneMemo/BBS/")
@Controller
public class OneMemoController {
	
	//서비스 주입]
	@Resource(name="memoService")
	private OneMemoService memoService;
	
	//목록 처리]
	@RequestMapping("List.do")
	public String list(@RequestParam Map map,Model model){
		//서비스 호출]
		List<OneMemoDTO> list= memoService.selectList(map);
		//데이타 저장]
		model.addAttribute("list", list);
		//뷰정보 반환]
		return "onememo10/bbs/List";
	}
}
