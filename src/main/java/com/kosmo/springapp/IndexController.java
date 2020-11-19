package com.kosmo.springapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
[일반 자바클래스 형태 즉 POJO(Plain Old Java Object)]

컴파일러에게 "아래 클래스는 사용자 요청을 처리하는 클래스야" 라고
알려주는 역할]-컨트롤러 클래스
*/

//컨트롤러 클래스
@Controller
public class IndexController {
	
	//컨트롤러 메소드]
	@RequestMapping("/handlermapping.do")
	public String handlerMapping() {
		//뷰정보 반환]
		return "handlermapping01/HandlerMapping";
	}/////////////handlerMapping]
	
	@RequestMapping("/controller.do")
	public String controller() {
		//뷰정보 반환]
		return "controller02/Controller";
	}/////////////controller
	
	@RequestMapping("/viewresolver.do")
	public String viewresolver() {
		//뷰정보 반환]
		return "viewresolver03/ViewResolver";
	}/////////////
	
	@RequestMapping("/returntype.do")
	public String returntype() {
		//뷰정보 반환]
		return "returntype04/ReturnType";
	}/////////////
	
	@RequestMapping("/injection.do")
	public String injection() {
		//뷰정보 반환]
		return "injection05/Injection";
	}/////////////
	@RequestMapping("/annotation.do")
	public String annotation() {
		//뷰정보 반환]
		return "annotation06/Annotation";
	}/////////////
	@RequestMapping("/database.do")
	public String database() {
		//뷰정보 반환]
		return "database07/Database";
	}/////////////
	@RequestMapping("/resource.do")
	public String resource() {
		//뷰정보 반환]
		return "resource08/Resource";
	}/////////////
	@RequestMapping("/validation.do")
	public String validation() {
		//뷰정보 반환]
		return "validation09/Validation";
	}/////////////
	
	@RequestMapping("/dynamicsql.do")
	public String dynamicsql() {
		//뷰정보 반환]
		return "dynamicsql10/DynamicSQL";
	}/////////////
	@RequestMapping("/ajax.do")
	public String ajax() {
		//뷰정보 반환]
		return "ajax11/Ajax";
	}/////////////
	@RequestMapping("/exception.do")
	public String exception() {
		//뷰정보 반환]
		return "exception12/Exception";
	}/////////////
}
