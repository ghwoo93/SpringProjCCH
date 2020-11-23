package com.kosmo.springapp.onememo.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo.springapp.onememo.service.MemoCommentService;

//@SessionAttributes({"id"})//씨큐리티 사용시 주석
@Controller
@RequestMapping("/OneMemo/Comment/")
public class CommentController {
	//서비스 주입]
	@Resource(name="commentService")
	private MemoCommentService commentService;
	
	//코멘트 입력처리]
	@RequestMapping(value="Write.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String write(
			//@ModelAttribute("id") String id, 
			Authentication auth,
			@RequestParam Map map) {
		//서비스 호출]
		//map.put("id", id);//(씨큐리티 미 사용시)한줄 댓글 작성자의 아이디를 맵에 설정
		map.put("id", ((UserDetails)auth.getPrincipal()).getUsername());
		commentService.insert(map);
		return map.get("no").toString();//원본글의 번호 반환
	}/////////////////
	//특정 글번호에 대한 코멘트 목록 가져오기]
	@ResponseBody
	@RequestMapping(value="List.do",produces = "text/html; charset=UTF-8")
	public String list(@RequestParam Map map) {
		//서비스 호출]
		List<Map> list=commentService.selectList(map);
		//pom.xml에 json-simple라이브러리 등록먼저
		//List에 저장된 객체는 반드시 Map이어야 한다
		System.out.println(JSONArray.toJSONString(list));
		/*
		[{"NO":5,"CPOSTDATE":2020-11-12 17:05:48.0,"CNO":6,"LINECOMMENT":"고마워요","ID":"LEE","NAME":"이길동"},{"NO":5,"CPOSTDATE":2020-11-12 16:14:12.0,"CNO":5,"LINECOMMENT":"다시 왔어요","ID":"KIM","NAME":"김길동"},{"NO":5,"CPOSTDATE":2020-11-12 16:13:55.0,"CNO":4,"LINECOMMENT":"또 왔어요","ID":"KIM","NAME":"김길동"},{"NO":5,"CPOSTDATE":2020-11-12 16:10:54.0,"CNO":3,"LINECOMMENT":"다시 봐도 굿이네요","ID":"KIM","NAME":"김길동"},{"NO":5,"CPOSTDATE":2020-11-12 16:10:33.0,"CNO":2,"LINECOMMENT":"글 좋네요","ID":"KIM","NAME":"김길동"}]
		 * 
		 */
		//날짜 값을 문자열로 변경해야한다 그렇지 않으면 JSON형식에 맞지 않는다
		//날짜를 2020-11-12 17:05:48.0에서 "2018-09-12"형태로 변경
		for(Map comment:list)
			comment.put("CPOSTDATE", comment.get("CPOSTDATE").toString().substring(0,10));
		return JSONArray.toJSONString(list);
	}////////////
	//코멘트 수정처리]
	@ResponseBody
	@RequestMapping(value="Edit.do",produces = "text/html; charset=UTF-8")
	public String update(@RequestParam Map map) {
		//서비스 호출]
		commentService.update(map);
		//원본글:댓글 번호 반환(확인)
		return String.format("%s : %s",map.get("no").toString(),map.get("cno").toString());
		
	}
	//코멘트 삭제처리]
	@ResponseBody
	@RequestMapping(value="Delete.do",produces = "text/html; charset=UTF-8")
	public String delete(@RequestParam Map map) {
		//서비스 호출]
		commentService.delete(map);
		//삭제 댓글 번호 반환(확인)
		return String.format("%s",map.get("cno").toString());
		
	}
	
}///////////////
