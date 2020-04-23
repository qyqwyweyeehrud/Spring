/**
 * http://usejsdoc.org/
 */
let mm = {}

mm.func = function(){
	$('#btnFind').click(function(){
		let param = $('#frm_mm').serialize();
		$.post("select.mm", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	$('#btnInsert').click(function(){
		let param = $('#frm_mm').serialize();
		$.post("insert.mm", param, function(data, state){
			$('#main').html(data);
			frm_mm.rDate.valueAsDate = new Date();
			
		});
	})

	$('#btnRegister').click(function(){
		let param = $('#frm_mm').serialize();
		$.post("insertR.mm", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnModify').click(function(){// 수정 폼
		let param = $('#frm_mm').serialize();
		$.post("modify.mm", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnUpdate').click(function(){//수정내용 저장
		let param = $('#frm_mm').serialize();
		$.post("modifyR.mm", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnDelete').click(function(){
		let param = $('#frm_mm').serialize();
		$.post("deleteR.mm", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnRepl').click(function(){ //답변 폼
		let param = $('#frm_mm').serialize();
		$.post("repl.mm", param, function(data, state){
			$('#main').html(data)
		});
	})
	$('#btnReplR').click(function(){ // 답변 저장
		let param = $('#frm_mm').serialize();
		$.post("replR.mm", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	
}

mm.init = function(){
	$('#main').load('select.mm');
}

mm.view = function(mId){
	frm_mm.mId.value = mId;
	let param = $('#frm_mm').serialize();
	console.log(param)
	$.post("view.mm", param, function(data, state){
		$('#main').html(data)
	});
}

mm.go = function(nowPage){
	frm_mm.nowPage.value = nowPage;
	let param = $('#frm_mm').serialize();
	console.log(param)
	$.post("select.mm", param, function(data, state){
		$('#main').html(data)
	});
}





