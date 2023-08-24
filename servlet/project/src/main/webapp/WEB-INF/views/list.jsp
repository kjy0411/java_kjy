<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 조회</h1>
	<a href="<%=request.getContextPath()%>/board/insert">게시글 입력</a> <hr>
	<table>
			<thead>
				<th>번호</th>
				<th>제  목</th>
				<th>아이디</th>
			</thead>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bo_num}</td>
				<td><a href="<c:url value='board/detail?bo_num=${board.bo_num}'/>">${board.bo_title}</a></td>
				<td>${board.bo_me_id}</td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>