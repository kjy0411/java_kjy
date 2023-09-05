<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<h3>제목 : ${board.bo_title }</h3>
	<h3>작성자 : ${board.bo_me_id }</h3>
	<h3>조회수 : ${board.bo_views }</h3>
	<hr>
	<div>${board.bo_contents }</div>
	<c:forEach items="${fileList}" var="file">
		<a 	href="<c:url
			value='/download${file.fi_name}'/>"
			download="${file.fi_ori_name}"
		>${file.fi_ori_name}</a> <br>
	</c:forEach>
	<a href="<c:url value='/board/list'/>">목록으로</a>
	<c:if test="${user.me_id == board.bo_me_id}">
		<a href="<c:url value='/board/update?bo_num=${board.bo_num }'/>">수정</a>
		<a href="<c:url value='/board/delete?bo_num=${board.bo_num }'/>">삭제</a>
	</c:if>
</body>
</html>