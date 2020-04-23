<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='board'>
	<div id='header'>게시물 수정 </div>

	<form name='frm_brd' id='frm_brd' method='post'>
		<!-- UI  -->
	
		<label>작성자</label>
		<input type='text' readonly name='id' value='${id }'/><br/>
		
		<label>제 목</label>
		<input type='text' name='subject' size='90' /><br/>
		<textarea name='content' class='content'></textarea><br/>

		<fieldset><legend>[ 파일 첨부 ]</legend>
			<input type='file' multiple="multiple" name='attFile'><hr/>
			<div id='attList'></div>
		</fieldset>	
		
		<fieldset><legend>[ 첨부된 파일 ]</legend>
			<c:forEach var='i' begin='1' end='10'>
				<div>
					<span>첨부된 파일${i } <input type='checkbox' name='delFile' value='${i }'></span>
				</div>
			</c:forEach>		
		</fieldset>
	
		<input type='button' id='btnUpdate' value='수정 저장'/>
		<input type='button' id='btnFind' value='목록으로'/>
		
		<input type='text' name='serial'  value='${param.serial }'/>
		<input type='text' name='findStr' value='${param.findStr }'/>
		<input type='text' name='nowPage' value='${param.nowPage }'/>
		<input type='text' name='pwd' />
	</form>
	
	<script>brd.func()</script>

</div>