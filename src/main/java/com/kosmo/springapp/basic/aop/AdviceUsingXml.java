package com.kosmo.springapp.basic.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//[XML파일 설정으로 AOP구현시 사용할 Advice]
//XML설정 파일에서 아래 클래스(POJO)를 Advice로 지정]
public class AdviceUsingXml {
	
	/*
	 * 반환타입:Object
	 * 메소드명:임의로
	 * 매개변수:ProceedingJoinPoint타입
	 * Throwable던져 준다.
	 */
	public Object crossCuttingConcern(ProceedingJoinPoint point) throws Throwable {
		//[대상 클래스의 핵심 로직(getTotal()) 실행전 수행할 공통로직]
		//삽입할 대상 클래스의 메소드명 얻기(확인용)
		String coreConcernName=point.getSignature().toShortString();
		System.out.println("대상 클래스의 핵심 관점(메소드)명:"+coreConcernName);
		long startTime=System.currentTimeMillis();
		//[대상 클래스의 핵심 로직(getTotal()) 실행]
		Object object=point.proceed();
		//[대상 클래스의 핵심 로직(getTotal()) 실행후 수행할 공통로직]
		long endTime=System.currentTimeMillis();
		System.out.println(coreConcernName+"의 총 소요 실행시간:"+(endTime-startTime)/1000.0+"초");
		return object;
	}////////////////
	
}
