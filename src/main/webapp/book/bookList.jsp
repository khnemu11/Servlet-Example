<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/menu.jsp"></c:import>
<fmt:requestEncoding value="utf-8"></fmt:requestEncoding>
<table border="1" align="center" width="600">

	<tr>
		<td>도서코드</td>
		<td>책이름</td>
		<td>저자</td>
		<td>출판사</td>
		<td>가격</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach items="${list}" var="book">
		<tr>
			<td>${book.isbn}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.company}</td>
			<td><fmt:formatNumber type="number"
					value="${book.price}"></fmt:formatNumber>원</td>
			<td>
				<form
					action="${pageContext.request.contextPath}/book/bookUpdate.jsp"
					method="post">
					<input type="hidden" name="isbn" value="${book.isbn}"> <input
						type="hidden" name="title" value="${book.title}"> <input
						type="hidden" name="author" value="${book.author}"> <input
						type="hidden" name="company" value="${book.company}"> <input
						type="hidden" name="price" value="${book.price}"> <input
						type="submit" value="수정">
				</form>
			</td>
			<td>
				<form action="${pageContext.request.contextPath}/deleteBook"
					method="post">
					<input type="hidden" name="isbn" value="${book.isbn}"> <input
						type="submit" value="삭제" onclick="return confirm('삭제할까요?')">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>