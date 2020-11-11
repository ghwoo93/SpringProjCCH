<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>List.jsp</title>

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
					<c:if test="${empty sessionScope.id}" var="isNotlogin">
						<li><a href="<c:url value="/OneMemo/Auth/Login.do"/>">로그인</a></li>
					</c:if>
					<c:if test="${not isNotlogin }">
						<li><a href="javascript:logout()">로그아웃</a></li>
					</c:if>
					<li><a href="<c:url value="/OneMemo/BBS/List.do"/>">한줄 댓글 게시판</a></li>
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
				한줄 메모 게시판<small>목록페이지</small>
			</h1>
		</div>
		<!-- 작성하기 버튼 -->
		<div class="row">
			<div class="col-md-12 text-right">
				<a href="<c:url value="/DataRoom/Write.kosmo"/>"
					class="btn btn-success">등록</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">&nbsp;</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table
					class="table table-bordered table-hover table-condensed text-center">
					<!-- 테이블 컬럼폭은 col-*-*계열로 설정 -->
					<tr>
						<th class="col-md-1 text-center">번호</th>
						<th class="text-center">제목</th>
						<th class="col-md-1 text-center">작성자</th>
						<th class="col-md-2 text-center">첨부파일</th>
						<th class="col-md-1 text-center">다운로드</th>
						<th class="col-md-2 text-center">등록일</th>
					</tr>
					<c:if test="${empty list }" var="isEmpty">
						<tr>
							<td colspan="6">등록된 게시물이 없어요</td>
						</tr>
					</c:if>
					<c:if test="${!isEmpty}">
						<c:forEach var="item" items="${list }" varStatus="loop">
							<tr>
								<td>${totalRecordCount - (((nowPage - 1) * pageSize) + loop.index)}</td>
								<td class="text-left"><a
									href="<c:url value='/DataRoom/View.kosmo?no=${item.no}&nowPage='/><c:out value='${param.nowPage}' default='1'/>">${item.title }</a></td>
								<td>${item.name}</td>
								<td class="attachfile"><a class="downfile${loop.count}"
									href="<c:url value="/DataRoom/Download.kosmo?filename=${item.attachFile}&no=${item.no}"/>">${item.attachFile}</a></td>
								<td id="downcount${loop.count}">${item.downCount}</td>
								<td>${item.postDate}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<!-- column -->
		</div>
		<!-- row -->
		<!-- 페이징 -->
		<div class="row">
			<div class="col-md-12 text-center">${pagingString }</div>
		</div>
	</div>
	<!-- container -->




	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


	<script>
		function logout(){
			location.replace("<c:url value="/OneMemo/Auth/Logout.do"/>");
		}	
	</script>

</body>
</html>
