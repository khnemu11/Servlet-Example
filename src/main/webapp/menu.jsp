<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	color: green;
	font-weight: bold;
	font-size: 30px;
}

body {
	margin: 0;
	padding: 0;
}

#menu {
	height: 100px;
	background-color: #eee;
}

a {
	display: inline-block;
	margin-top: 40px;
	text-decoration: none;
	font: bold;
	width: 100px;
	text-align: center;
}

#login_info {
	font-size: 12px;
}
</style>
</head>
<body>
	<div id="menu">
		<a href="${pageContext.request.contextPath}/index.jsp">HOME</a> <a
			href="${pageContext.request.contextPath}/login/login.jsp">로그인 화면</a>
		<c:choose>
			<c:when test="${userid != null}">
				<a href="${pageContext.request.contextPath}/book/bookInsert.jsp">도서등록</a>
				<a href="${pageContext.request.contextPath}/listBook">도서목록</a>
				<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
				<span id="login_info">${userid} 님이 로그인 하셨습니다</span>
			</c:when>
		</c:choose>

	</div>
	<hr>
</body>
</html>