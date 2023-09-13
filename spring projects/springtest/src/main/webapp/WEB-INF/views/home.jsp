<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  ${num}
</h1>
<span>test</span>
<a href="<c:url value='/member/login2?id=abc&pw=def'/>">id& pw</a>
<form action="<c:url value='/member/login2'/>" method="get">
	ID : <input type="text" name="id"> <br>
	PW : <input type="password" name="pw"> <br>
	<button>login</button>
</form>
<h1>여러 회원 정보를 서버에 전송 : login3</h1>
<form action="<c:url value='/member/login3'/>" method="get">
	<h3>회원1</h3>
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<h3>회원2</h3>
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<h3>회원3</h3>
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<button>login</button>
</form>
<h1>여러 회원 정보를 서버에 전송 : login4</h1>
<form action="<c:url value='/member/login4'/>" method="get">
	<c:forEach begin="0" end="2" var="i">
		<h3>회원${i+1}</h3>
		<input type="text" name="List[${i}].id"> <br>
		<input type="password" name="List[${i}].pw"> <br>
	</c:forEach>
	<button>login</button>
</form>
</body>
</html>
