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
         error : function(xhr, status, error){
            console.log(error);
         },
         success : function(data, xhr, status) {
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
		let pwd = prompt("수정하려면 암호 입력!");
		if(pwd==null || pwd=='') return;//입력하지않고 취소버튼을 누르면 값이 null로 온다
		frm_brd.pwd.value = pwd;
		
		let fd = new FormData($('#frm_brd')[0]); // 오븍젝트형태로 데이터가 만들어짐
		$.ajax({
	         url : 'modifyR.brd',
	         type : 'post',
	         data : fd,
	         contentType: false,
	         processData : false,
	         error : function(xhr, status, error){
	            console.log(error);
	         },
	         success : function(data, xhr, status) {
	            $('#main').html(data);
	         }
	      
	      }
	      )
	})

	$('#btnDelete').click(function(){
		let pwd = prompt("삭제하려면 암호 입력!");
		if(pwd==null || pwd=='') return;//입력하지않고 취소버튼을 누르면 값이 null로 온다
		frm_brd.pwd.value = pwd;
		
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
		let fd = new FormData($('#frm_brd')[0]); // 오븍젝트형태로 데이터가 만들어짐
		$.ajax({
	         url : 'replR.brd',
	         type : 'post',
	         data : fd,
	         contentType: false,
	         processData : false,
	         error : function(xhr, status, error){
	            console.log(error);
	         },
	         success : function(data, xhr, status) {
	            $('#main').html(data);
	         }
	      
	      }
	      )
	})
	
	
	$('#btnAtt').change(function(){
		let str = '<ol>';
		
		let files = $('#btnAtt')[0].files;
		for(f of files){
			str += "<li>" + f.name + "[" + parseInt(f.size/1000) + " KB ]";
		}
		str += '</ol>';
		$('#attList').html(str);
	})
	//java script로하면
//	if(getId('btnAtt')!=null){
//		let btn = getId('btnAtt');
//		btn.onchange =function(){
//			let attList = getId('attList');
//			let str = "<ul>";
//			let files = btn.files;
//			for(f of files){
//				str += "<legend>첨부된 파일목록</legend>";
//				str += "<li>" + f.name + "(" + parseInt(f.size/1000) + " KB )" +"</li>";
//			}
//			str+= "</ul>";
//			attList.innerHTML = str;	
//		}
//	}
	
	
	
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

brd.delCheck = function(ev){ //ev는 체크박스 자기자신
	let tag = ev.parentElement.childNodes[1]; //텍스트 노드가 0번째고 span이 1 (만약띄어뜨기없이 붙어있다면 span이 0이될수있다)
	if(ev.checked){
		tag.style.textDecoration = 'line-through';
		tag.style.color = 'red';
	}else{
		tag.style.textDecoration = 'none';
		tag.style.color = 'black';
	}
}





