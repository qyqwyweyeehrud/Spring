let brd = {}

brd.func = function(){
	$('#btnFind').click(function(){
		$('#frm_brd').removeAttr('encType');
		//frm_brd.enctype='';
		let param = $('#frm_brd').serialize();
		$.post("select.brd", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	$('#btnInsert').click(function(){
		let param = $('#frm_brd').serialize();
		$.post("insert.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

//	$('#btnRegister').click(function(){
//		let fd = new FormData($('#frm_brd')[0])
//		console.log(fd);
//		$.ajax({							//enctype일 경우에만 이렇게 해야한다
//			url : 'insertR.brd',
//			type : 'post',
//			data : fd,//엔크타입일때는 폼데이터라는 객체를 만들어서 전달해주기도하지만, / 앤크타입이 아니라면 파람을 만들어서 데이터를 넣어도 상관없어 / 이 데이터는 json타입으로 데이터가 넘어간다
//			contentType: false,
//			processData : false,
//			error : function(xhr,status,err){console.log(error)},
//			success : function(data,xhr,status){
//				$('#main').html(data);
//			}
//		})
//		
//		let param = $('#frm_brd').serialize();
//		$.post("insertR.brd", param, function(data, state){
//			$('#main').html(data)
//		});
//	})
	$('#btnRegister').click(function(){
      let fd = new FormData($('#frm_brd')[0]); // 오븍젝트형태로 데이터가 만들어짐
      
      $.ajax({
         url : 'insertR.brd',
         type : 'post',
         data : fd,
         contentType: false,
         processData : false,
         error : function(xhr, statue, error){
            console.log(error);
         },
         success : function(data, xhr, statues) {
            $('#main').html(data);
         }
      
      }
      )
      
      
      
      let param = $('#frm_brd').serialize();
      $.post("insertR.brd", param, function(data, state){
         $('#main').html(data)
      });
   })

	$('#btnModify').click(function(){// 수정 폼
		let param = $('#frm_brd').serialize();
		$.post("modify.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnUpdate').click(function(){//수정내용 저장
		let param = $('#frm_brd').serialize();
		$.post("modifyR.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnDelete').click(function(){
		let param = $('#frm_brd').serialize();
		$.post("deleteR.brd", param, function(data, state){
			$('#main').html(data)
		});
	})

	$('#btnRepl').click(function(){ //답변 폼
		let param = $('#frm_brd').serialize();
		$.post("repl.brd", param, function(data, state){
			$('#main').html(data)
		});
	})
	$('#btnReplR').click(function(){ // 답변 저장
		let param = $('#frm_brd').serialize();
		$.post("replR.brd", param, function(data, state){
			$('#main').html(data)
		});
	})
	
	
}

brd.init = function(){
	$('#main').load('select.brd');
}

brd.view = function(serial){
	frm_brd.serial.value = serial;
	let param = $('#frm_brd').serialize();
	console.log(param)
	$.post("view.brd", param, function(data, state){
		$('#main').html(data)
	});
}

brd.go = function(nowPage){
	frm_brd.nowPage.value = nowPage;
	let param = $('#frm_brd').serialize();
	console.log(param)
	$.post("select.brd", param, function(data, state){
		$('#main').html(data)
	});
}





