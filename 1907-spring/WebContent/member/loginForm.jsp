<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel='stylesheet' type='text/css' href='../css/index.css'/>
	
</head>
<body>

<div id='body' class='login'>

	<div><%@include file="../header.jsp" %></div>
	
	<form name='frm_login' id='frm_login' method='post'>
		<fieldset>
			<legend> [ LOGIN ] </legend>
			<label>아뒤</label>
			<input type='text' name='id' value='hong'></br/>
			<label>암호</label>
			<input type='password' name='pwd' value='1'></br/>
			<br/>
			
			<input type='button' id='btnBack'   class='btnLogin' value='취소' onclick='history.back()'/>
			<input type='button' id='btnLoginR' class='btnLogin' value='로그인'/>
			<br/><br/>
			<a href='' >아이디/암호찾기</a>
		</fieldset>
	</form>
	
	<div><%@include file="../footer.jsp" %></div>

</div>
</body>
</html>