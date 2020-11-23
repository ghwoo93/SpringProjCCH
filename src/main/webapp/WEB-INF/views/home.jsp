<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<!-- 점보트론(Jumbotron) -->
	<div class="page-header">
		<h1>
			스프링<small>프레임워크</small>
		</h1>
	</div>
	<p>The time on the server is ${serverTime}.</p>
	<fieldset>
		<legend>static resource(이미지,동영상,.css,.js파일등)표시방법</legend>
		<h2>servlet-context.xml파일에 설정된 resources태그
			사용-webapp/resources디렉토리 아래에 리소스 저장</h2>
		<!-- 빈 설정파일  servlet-context.xml의 매핑명으로 경로 설정-->
		<img src="<c:url value="/static/images/sumnail.png"/>" alt="매핑 이름으로" />

		<h2>servlet-context.xml파일에 설정된 resources태그 사용-폴더 생성후 매핑이름 지정(폴더명과
			같지 않아도 된다)</h2>
		<img src="<c:url value="/images/sumnail.png"/>" alt="매핑 이름으로" />
		<h2>resources태그 미 사용-&lt;default-servlet-handler/&gt;-디렉토리명으로 접근</h2>
		<img src="<c:url value="/images/sumnail.png"/>" alt="디렉토리 구조로 접근" />

	</fieldset>
	<fieldset>
		<legend>스프링 익히기</legend>
		<ul style="list-style: decimal">
			<li><a href="<c:url value="/handlermapping.do"/>">핸들러 매핑</a></li>
			<li><a href="<c:url value="/controller.do"/>">컨트롤러</a></li>
			<li><a href="<c:url value="/viewresolver.do"/>">뷰 리졸버</a></li>
			<li><a href="<c:url value="/returntype.do"/>">컨트롤러의 반환타입</a></li>
			<li><a href="<c:url value="/injection.do"/>">Dependency
					Injection</a></li>
			<li><a href="<c:url value="/annotation.do"/>">Annotation</a></li>
			<li><a href="<c:url value="/database.do"/>">데이타베이스</a></li>
			<li><a href="<c:url value="/resource.do"/>">리소스</a></li>
			<li><a href="<c:url value="/validation.do"/>">유효성 검증</a></li>
			<li><a href="<c:url value="/dynamicsql.do"/>">마이바티스 동적SQL</a></li>
			<li><a href="<c:url value="/ajax.do"/>">Ajax 요청</a></li>
			<li><a href="<c:url value="/exception.do"/>">예외처리</a></li>
			<li><a href="<c:url value="/fileupdown.do"/>">파일업로드/다운로드</a></li>
			<li><a href="<c:url value="/aop.do"/>">AOP</a></li>
			<li><a href="<c:url value="/websocket.do"/>">웹소켓</a></li>
			<li><a href="<c:url value="/tiles.do"/>">타일즈 적용 테스트</a></li>
		</ul>

	</fieldset>

</div>


