<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='select.brd'>게시판 조회</a>
	<a href='select.mm'>회원 조회</a>
	<hr/>
	
	<%
	String inc = "select.brd";
	if(request.getParameter("inc") !=null) inc = request.getParameter("inc");
	%>
	<jsp:include page="<%=inc %>"></jsp:include>
</body>
</html>