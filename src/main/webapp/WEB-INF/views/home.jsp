<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>Home.jsp</title>

<!-- 부트스트랩 -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- static resource 테스트용 -->   
<link rel="stylesheet"	href="<c:url value="/styles/common.css"/>">
<style>
	body{
		padding-top:70px;
	}
</style>
</head>
<body>
	<!--상단메뉴 시작-->
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="container-fluid">
			<!--화면 크기가 작을때 보여지는 네비게이션바(모바일용)  -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#collapse-menu">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href='<c:url value="/"/>'><span
					class="glyphicon glyphicon-education"></span> KOSMO</a>
			</div>
			<!-- 화면 크기가 클때 상단에 보여지는 메뉴(데스크탑용) -->
			<div class="collapse navbar-collapse" id="collapse-menu">
				<!-- 네비게이션바에 폼 추가 -->
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="검색">
					</div>
					<button type="submit" class="btn btn-info">확인</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/"/>">HOME</a></li>
					<c:if test="${empty sessionScope.id}" var="isNotlogin">
						<li><a href="<c:url value="/OneMemo/Auth/Login.do"/>">로그인</a></li>
					</c:if>
					<c:if test="${not isNotlogin }">
						<li><a href="javascript:logout()">로그아웃</a></li>
					</c:if>
					<li><a href="<c:url value="/OneMemo/BBS/List.do"/>">한줄 댓글
							게시판</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--  상단 메뉴 끝 -->
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
			<h2>servlet-context.xml파일에 설정된 resources태그 사용-webapp/resources디렉토리 아래에  리소스 저장</h2>
			<!-- 빈 설정파일  servlet-context.xml의 매핑명으로 경로 설정-->
			<img src="<c:url value="/static/images/sumnail.png"/>" alt="매핑 이름으로"/>
			
			<h2>servlet-context.xml파일에 설정된 resources태그 사용-폴더 생성후 매핑이름 지정(폴더명과 같지 않아도 된다)</h2>
			<img src="<c:url value="/images/sumnail.png"/>" alt="매핑 이름으로"/>
			<h2>resources태그 미 사용-&lt;default-servlet-handler/&gt;-디렉토리명으로 접근</h2>
			<img src="<c:url value="/images/sumnail.png"/>" alt="디렉토리 구조로 접근"/>
		
		</fieldset>
		<fieldset>
			<legend>스프링 익히기</legend>
			<ul style="list-style:decimal">
				<li><a href="<c:url value="/handlermapping.do"/>">핸들러 매핑</a></li>
				<li><a href="<c:url value="/controller.do"/>">컨트롤러</a></li>
				<li><a href="<c:url value="/viewresolver.do"/>">뷰 리졸버</a></li>
				<li><a href="<c:url value="/returntype.do"/>">컨트롤러의 반환타입</a></li>
				<li><a href="<c:url value="/injection.do"/>">Dependency Injection</a></li>
				<li><a href="<c:url value="/annotation.do"/>">Annotation</a></li>
				<li><a href="<c:url value="/database.do"/>">데이타베이스</a></li>
				<li><a href="<c:url value="/resource.do"/>">리소스</a></li>
				<li><a href="<c:url value="/validation.do"/>">유효성 검증</a></li>
			</ul>
		
		</fieldset>
		
	</div>

	
	
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
</body>
</html>
