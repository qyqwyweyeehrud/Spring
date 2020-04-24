<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<div id='board'>
	<div id='header'>게시물 상세보기 </div>

	<form name='frm_brd' id='frm_brd' method='post'>
		<!-- UI  -->
		<label>작성자</label>
		<input type='text' readonly name='id' value='${vo.id }'/><br/>
		
		<label>제 목</label>
		<input type='text' name='subject' size='90' value='${vo.subject }'/><br/>
		<textarea name='content' class='content'>${vo.content }</textarea><br/>

		
		<c:choose>
			<c:when test="${fn:length(attList)==0 }">
				첨부된 파일이 없습니다
			</c:when>
			<c:otherwise>
				<fieldset><legend>[ 첨부된 파일 ]</legend>
					<c:forEach var='i' items='${attList }'>
						<div>
							<span>${i.oriFile }</span>
						</div>
					</c:forEach>
				</fieldset>
			</c:otherwise>
		</c:choose>



	
		<input type='button' id='btnModify' value='수정'/>
		<input type='button' id='btnDelete' value='삭제'/>
		<input type='button' id='btnRepl' value='답글'/>
		<input type='button' id='btnFind' value='목록으로'/>
		
		<input type='text' name='pwd'/>
		<input type='text' name='serial' value='${vo.serial }'/>
		<input type='text' name='findStr' value='${p.findStr }'/>
		<input type='text' name='nowPage' value='${p.nowPage }'/>
	</form>

	<script>brd.func()</script>
</div>