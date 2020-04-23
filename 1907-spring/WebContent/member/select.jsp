<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='member'>
	<div id='header'>회원 정보 조회 </div>

	<form name='frm_mm' id='frm_mm' method='post' class='frm_mm'>
		<input type='text' name='nowPage' value='${param.nowPage }'/>
		<input type='text' name='mId' value='${param.mId }'/>
		<input type='button' value='입력' id='btnInsert' />
		<input type='text' name='findStr' value='${param.findStr }'/>
		<input type='button' value='검색' id='btnFind'/>
	</form>
	<!-- list  -->
	<div class='list'>
		<c:forEach var='i' begin='1' end='30'>
			<div class='items' onclick='mm.view(${i})'>
				<span class='no'>NO : ${i }</span>
				<span class='mId'>아이디 : <br/>${i}</span>
				<span class='mName'>성명 : <br/>${i }</span>
				<span class='rDate'>등록일 : <br/> ${i }</span>
				<span class='grade'>학년 : <br/>${i }</span>
				<span class='photo'><img src='./images/anno.png'></span>
				
			</div>		
		</c:forEach>
	</div>
		
	
	<div id='paging'>
		<input type='button' value=' 이전 ' onclick = 'mm.go(1)' />
		<c:forEach var='i' begin='1' end='10'>
			<input type='button' value=' ${i } ' class="${(i==param.nowPage)? 'here' : '' }" 
						onclick='mm.go(${i})' />
		</c:forEach>
		<input type='button' value=' 다음 ' onclick='mm.go(11)' />
	</div>	
	
	<script>mm.func()</script>


</div>