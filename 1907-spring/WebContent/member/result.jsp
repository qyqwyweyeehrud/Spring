<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='member'>
	<div id='result'>
		<div id='header'>결과 </div>
		${msg }	
		<br/><br/>
			<form name='frm_mm' id='frm_mm' method='post'>
				<input type='button' id='btnFind' value='목록으로'/>
				
				<input type='text' name='findStr' value='${param.findStr }'/>
				<input type='text' name='nowPage' value='${param.nowPage }'/>
			</form>
	 </div>
	<script>mm.func()</script>



</div>