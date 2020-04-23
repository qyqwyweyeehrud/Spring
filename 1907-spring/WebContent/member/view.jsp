<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='member' class='frm_modify'>
	<div id='header'>회원 정보 상세보기 </div>

	<form name='frm_mm' id='frm_mm' method='post'>
		<!-- UI  -->
			<label>아이디</label>
			<input type='text' name='mId'><br/>
			<label>성 명</label>
			<input type='text' name='mName'><br/>
			
			<label>등록일</label>
			<input type='date' name='rDate'><br/>
		
			<label>학년</label>
			<select name='grade'>
				<option value='1'>1 학년</option>
				<option value='2'>2 학년</option>
				<option value='3'>3 학년</option>
				<option value='4'>4 학년</option>
			</select><br/>
	
		<input type='button' id='btnModify' value='수정'/>
		<input type='button' id='btnDelete' value='삭제'/>
		<input type='button' id='btnFind' value='목록으로'/>
		
		<input type='text' name='mId' value='${param.mId }'/>
		<input type='text' name='findStr' value='${param.findStr }'/>
		<input type='text' name='nowPage' value='${param.nowPage }'/>
	</form>

	<script>mm.func()</script>


</div>