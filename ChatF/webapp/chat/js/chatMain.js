$(function() {
	//var textarea = document.getElementById("messageWindow");
	//로그인한 유저 아이디 대화창 센드할때 보내기 

	//alert(user);

	var webSocket = new WebSocket('ws://localhost/broadcasting');
	var inputMessage = document.getElementById('inputMessage');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
		//textarea.value += event.data + "\n"; 
		
		var printHtml2 = "<div class='well'>";
		var d2 = new Date();
		var dateStr2 = d2.getHours() +":"+ d2.getMinutes() +":"+ d2.getSeconds();
		
		printHtml2 += "<div class = 'alert alert-info'>";
		printHtml2 += event.data;
		printHtml2 += "<font color='#cccccc' size='2pt'>&nbsp; &nbsp; &nbsp;"+ dateStr2 +"</font>";
		printHtml2 += "</div>";
		
		$(".messageField").append(printHtml2);
		
		
		//스크롤바 자동 내리기 
		const top = $('#messageField').prop('scrollHeight');
		$('#messageField').scrollTop(top);
		//----------------	
		
		updateScroll(); 
		gotoscroll();

	}

	
	
	function onOpen(event) {
	//	textarea.value += "You entered the chat room.\n";
		$(".messageField").append("Welcom to the ChatF");
	}
	function onError(event) {
		alert(event.data);
	}

	$("input[value=send]").on("click", function() {
		send();
		$("#inputMessage").focus();
	})

	$('#inputMessage').keypress(function(e) {
		var code = e.keyCode || e.which;
		if (code === 13) {
			send();
			//$('#inputBtn').trigger('click');
			return false;
		}
	})

	function updateScroll(){
	    var element = document.getElementById("messageField");
	    element.scrollTop = element.scrollHeight;
	}
	

	function messageLogWrite(user, msg, datestr){
		var prm = "user="+user+"&msg="+msg+"&datestr="+datestr;
		$.ajax({
			url :"/chat_logServelet",
			method:"post",
			data:prm,
			success:function(res){
				console.log(res);
				console.log("ok");
			},
			error:function(res){
				console.log(res);
				console.log("error");
			},
		})
	}
	
	
//	function dateToHHMISS(date){
//	    function pad(num) {
//	        num = num + '';
//	        return num.length < 2 ? '0' + num : num;
//	    }
//	    return pad(d.getHours()) +":"+ pad(d.getMinutes()) +":"+ pad(d.getSeconds());
//	}
	
	
	function send() {
		
		//로그인한 유저 아이디 대화창 센드할때 보내기 
		
		if(user == null || user=='') {
			user = "guest"
			
		} 
		var d = new Date();
		var dateStr = d.getHours() +":"+ d.getMinutes() +":"+ d.getSeconds();
		var printHtml = "<div class='well'>";
		printHtml += "<div class = 'alert alert-info'>";
		printHtml += "<strong>["+user+"] : "  + inputMessage.value + "</strong>";
		printHtml += "<font color='#cccccc' size='2pt'>&nbsp; &nbsp; &nbsp;"+dateStr+"</font>";
		printHtml += "</div>";
		
		
		messageLogWrite(user, inputMessage.value, dateStr);
		
		
		
		
		$(".messageField").append(printHtml);
		
		
	//	textarea.value += user +" : " + inputMessage.value + "\n";
		webSocket.send(user+" : " + inputMessage.value);
		
		inputMessage.value = "";
		

		//스크롤바 자동 내리기 
		const top = $('#messageWindow').prop('scrollHeight');
		$('#messageWindow').scrollTop(top);
		//----------------
		updateScroll(); 
		

	}
	
	
	
	
})
