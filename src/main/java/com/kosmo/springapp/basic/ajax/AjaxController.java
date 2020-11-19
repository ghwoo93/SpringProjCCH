package com.kosmo.springapp.basic.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;
import com.kosmo.springapp.onememo.service.impl.OneMemoDAO;

@Controller
public class AjaxController {
	
	@Resource(name="memoService")
	private OneMemoService service;
	
	//[ajax 미 사용]-새로고침이 됨.
	/* 반환타입 void:직접 웹브라우저에 출력 스트림으로 결과값 출력
	*  반환타입 String:디스패처서블릿에게 뷰 반환, 결과값은 모델에 저장(JSP로 포워드)
	*/
//	@RequestMapping("/Ajax/NoAjax.do")
//	public void noajax(@RequestParam Map map,HttpServletResponse resp) throws IOException {
//		//1]컨텐츠 타입 설정
//		resp.setContentType("text/html; charset=UTF-8");
//		//2]웹브라우저에 출력하기위한 출력스트림 얻기
//		PrintWriter out=resp.getWriter();
//		//3]비지니스 로직 호출
//		boolean isLogin=service.isLogin(map);
//		if(isLogin)
//			out.println("<h2>"+map.get("id")+"님 즐감하세요</h2>");
//		else {
//			out.println("<script>");
//			out.println("alert('아뒤와 비번이 틀려요');");
//			out.println("history.back();");
//			out.println("</script>");
//		}
//		//4]웹브라우저와 연결된 스트림 닫기
//		out.close();
//	}//////////////////
	@RequestMapping("/Ajax/NoAjax.do")
	public String noajax(@RequestParam Map map,Model model) {
		//1]서비스 호출
		boolean isLogin=service.isLogin(map);
		//2]데이타 저장
		model.addAttribute("isLogin", isLogin?map.get("id")+"님 반갑습니다":"회원정보 불일치");
		//3]뷰 정보 반환
		 return "ajax11/Ajax";
	}///////////////////////
	//[AJAX 사용]
	/*
	 * 반환타입은 void이거나 
	 * 반환타입이 String인 경우는 @ResponseBody()어노테이션 사용
	 */
	//[TEXT로 응답할때]	
//	@RequestMapping("/Ajax/AjaxText.do")
//	public void ajaxText(@RequestParam Map map,HttpServletResponse resp) throws IOException {
//		//1]컨텐츠 타입 설정
//		resp.setContentType("text/html; charset=UTF-8");
//		//2]웹브라우저에 출력하기위한 출력스트림 얻기
//		PrintWriter out=resp.getWriter();
//		//3]비지니스 로직 호출
//		boolean isLogin=service.isLogin(map);
//		//3-1]웹브라우저에 출력
//		//Y 혹은 N 값으로 응답할때-반드시 print()메소드로 안그러면 println은 줄바꿈이 추가됨
//		//out.print(isLogin ? "Y":"N");
//		//메시지로 응답할때
//		out.print(isLogin ? map.get("id")+"님 즐감!!!":"회원 가입해....");
//		//4]웹브라우저와 연결된 스트림 닫기
//		out.close();
//	}//////////////
	//반환 타입 String]
	@RequestMapping(value="/Ajax/AjaxText.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String ajaxText(@RequestParam Map map) {
		//1]서비스 호출
		boolean isLogin=service.isLogin(map);
		//Y 혹은 N 값으로 응답할때
		//return isLogin?"Y":"N";
		//메시지로 응답할때
		return isLogin?"Welcome!!!":"No Authorized!!!";
	}/////////////
	//[JSON으로 응답할때]
	@RequestMapping(value="/Ajax/AjaxJson.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String ajaxJson(@RequestParam Map map) {
		Integer.parseInt("aaaa");
		//1]서비스 호출
		boolean isLogin=service.isLogin(map);
		//JSON데이타 타입으로 반환하기위해 JSONObject객체 생성
		JSONObject json = new JSONObject();
		//JSON객체의 put("키값","값")메소드로 저장하면
		//{"키값":"값"} JSON형태의 데이타로 저장됨.
		json.put("isLogin", isLogin ? "방가방가":"다음 기회에...");
		System.out.println("json.toString() : "+json.toString());
		System.out.println("json.toJSONString() : "+json.toJSONString());
		return json.toJSONString();
	}/////////////
	
	//[JSON 배열로 응답할때]
	@RequestMapping(value="/Ajax/AjaxJsonArray.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String ajaxJsonArray() {
		//1]서비스 호출
		Map map = new HashMap();
		map.put("start",1);
		map.put("end",10);
		List<OneMemoDTO> list= service.selectList(map);
		//[{},{},{},{}]형태로 반환.
		
		/*JSONArray의 정적 메소드인 toJSONString(List계열 컬렉션)
		호출시에는 List계열 컬렉션에 반드시 Map계열 컬렉션이 저장되어야 한다]		
		OneMemoDTO를 Map으로 변경]		
		OneMemoDTO를 Map으로 저장해서
		List계열 컬렉션에 저장
		*/
		List<Map> collections = new Vector<Map>();
		for(OneMemoDTO dto : list) {
			Map record = new HashMap();
			record.put("title",dto.getTitle());
			record.put("name",dto.getName());
			record.put("postDate",dto.getPostDate().toString());
			collections.add(record);
		}
		/*
		※아래 형태로 반환됨.즉 날짜가 문자열로 처리가 안되 있다- toString()로 문자열로 변환하면된다
		[{"name":"김길동","postDate":2020-11-18,"title":"2222"},{"name":"김길동","postDate":2020-11-18,"title":"111111"},{"name":"이길동","postDate":2020-11-17,"title":"제목2입니다"},{"name":"이길동","postDate":2020-11-16,"title":"제목"},{"name":"이길동","postDate":2020-11-16,"title":"제목"},{"name":"이길동","postDate":2020-11-12,"title":"제목"},{"name":"박길동","postDate":2020-11-12,"title":"박입니다"},{"name":"김길동","postDate":2020-11-12,"title":"제목1"}]

		 */
		
		System.out.println(JSONArray.toJSONString(collections));
		return JSONArray.toJSONString(collections);
	}/////////////
	@RequestMapping(value="/Ajax/AjaxCourse.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String ajaxCourse(@RequestParam String course) {
		JSONObject obj = new JSONObject();
		switch(course) {
			case "java":
				obj.put("j01", "자바");
				obj.put("j02", "JSP");
				obj.put("j03", "스프링");
				break;
			case "dotnet":
				obj.put("d01", "C#");
				obj.put("d02", "ASP.NET");
				obj.put("d03", "WPF4");				
				break;
			default:
				obj.put("i01", "라즈베리 파이");
				obj.put("i02", "파이썬");				
		}
		return obj.toJSONString();
	}/////////////////////
}
