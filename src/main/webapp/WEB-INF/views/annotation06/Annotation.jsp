<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>Annotation.jsp</title>

<!-- 부트스트랩 -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
body {
	padding-top: 70px;
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
				<a class="navbar-brand" href='<c:url value="/"/>'><span
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
					<li><a href="#">로그인</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--  상단 메뉴 끝 -->
	<div class="container">
		<!-- 점보트론(Jumbotron) -->
		<div class="jumbotron">
			<h1>
				스프링<small>Annotation</small>
			</h1>
		</div>
		<fieldset>
			<legend>어노테이션</legend>
			<h2>리퀘스트 영역에 저장된 값들</h2>
			\${requestScope.loginInfo } : ${requestScope.loginInfo }
			<hr />

			<fieldset>
				<legend>@RequestMapping / @PathVariable</legend>
				<h4>@RequestMapping("/요청 URL패턴"):GET/POST둘다 처리 가능</h4>
				<form method="post"
					action="<c:url value='/Annotation/RequestMappingBoth.do'/>">
					아이디 <input type="text" name="UserID" /> 비번 <input type="password"
						name="UserPWD" /> <input type="submit" value="로그인" />
				</form>
				<h4>@RequestMapping(value="/요청URL패턴",method=RequestMethod.GET):GET/POST둘중
					하나만 처리 가능</h4>
				<form method="post"
					action='<c:url value="/Annotation/RequestMappingOne.do"/>'>
					아이디 <input type="text" name="user" /> 비번 <input type="password"
						name="pass" /> <input type="submit" value="로그인" />
				</form>
			</fieldset>
			<hr />

			<span style="color: green; font-size: 1.4em">이름: ${name} ,10년후
				나이:${years}</span>

			<fieldset>
				<legend>@RequestParam ${errorNumber}${empty param.error ?"":"나이는 숫자만 입력"}</legend>
				<!-- 
     		예]
  			  //컨트롤러 메소드]
			  public String 메소드(@RequestParam 자료형 매개변수){
			  
			  }
 
       			단, 파라미터명과  매개변수명이 일치하지 않은 경우
    			@RequestParam("파라미터명") 자료형 매개변수명
      
     			- 해당 파라미터의 자료형으로 받을 수 있다 
             	    즉 형변환 불필요
     			- 파라미터가 1~2개 정도일때 유리 (여개개일때는 자료형을 Map으로)      
     			-->
				<h4>파라미터명과 매개변수명 일치시</h4>
				<form action='<c:url value="/Annotation/RequestParamEqual.do"/>'>
					이름 <input type="text" name="name" value="${param.name}" /> 나이 <input
						type="text" name="years" value="${param.years}" /> <input
						type="submit" value="확인" />
				</form>
				<h4>파라미터명과 매개변수명 불일치시</h4>
				<form action='<c:url value="/Annotation/RequestParamDiff.do"/>'>
					이름 <input type="text" name="nick2" /> 나이 <input type="text"
						name="age" /> <input type="submit" value="확인" />
				</form>
				<h4>파라미터를 맵으로 모두 받기</h4>

				<span style="color: green; font-size: 1.2em; font-weight: bold">이름:${nick },나이:${age },관심사항:${inters },성별:${gender }</span>

				<form action='<c:url value="/Annotation/RequestParamMap.do"/>'>
					이름 <input type="text" name="nick" /> 나이 <input type="text"
						name="age" /> 관심사항: <input type="checkbox" name="inters"
						value="정치" />정치 <input type="checkbox" name="inters" value="경제" />경제
					<input type="checkbox" name="inters" value="연예" />연예 성별: <input
						type="radio" name="gender" value="남자" />남자 <input type="radio"
						name="gender" value="여자" />여자 <input type="submit" value="확인" />
				</form>
			</fieldset>
			<hr />
			<fieldset>
				<legend>@ModelAttribute</legend>
				<form action="<c:url value='/Annotation/ModelAttribute.do'/>"
					method="post">
					<table bgcolor="gray" cellspacing="1" width="60%">
						<tr bgcolor="white">
							<td>이름</td>
							<td><input type="text" name="name" /></td>
						</tr>
						<tr bgcolor="white">
							<td>나이</td>
							<td><input type="text" name="years" /></td>
						</tr>
						<tr bgcolor="white">
							<td>성별</td>
							<td><input type="radio" name="gender" value="남자" />남자 <input
								type="radio" name="gender" value="여자" />여자</td>
						</tr>
						<tr bgcolor="white">
							<td>관심사항</td>
							<td><input type="checkbox" name="inters" value="정치" />정치 <input
								type="checkbox" name="inters" value="경제" />경제 <input
								type="checkbox" name="inters" value="스포츠" />스포츠</td>
						</tr>
						<tr bgcolor="white">
							<td>학력</td>
							<td><select name="grade">
									<option value="초등학교">초등학교</option>
									<option value="중학교">중학교</option>
									<option value="고등학교">고등학교</option>
									<option value="대학교">대학교</option>
							</select></td>
						</tr>
						<tr bgcolor="white">
							<td>자기소개</td>
							<td><textarea name="self" cols="30" rows="10"></textarea></td>
						</tr>
						<tr bgcolor="white" align="center">
							<td colspan="2"><input type="submit" value="확인" /></td>
						</tr>
					</table>
				</form>
			</fieldset>
			<hr/>
			<fieldset>
				<legend>DI와 관련된 어노테이션들 ${message !=null ? message :""}</legend>
				<ul style="list-style: decimal;">
					<li><a href="<c:url value="/Annotation/Autowired.do"/>">@Autowired</a></li>
					<li><a href="<c:url value="/Annotation/Resource.do"/>">@Resource</a></li>
				</ul>		
			
			</fieldset>


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
