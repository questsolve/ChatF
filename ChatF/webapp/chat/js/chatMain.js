
	$(function() {
		var textarea = document.getElementById("messageWindow");
		var webSocket = new WebSocket('ws://localhost/ChatF/broadcasting');
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
			textarea.value += "상대 : " + event.data + "\n";
		}
		function onOpen(event) {
			textarea.value += "You entered the chat room.\n";
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

		function send() {
			textarea.value += "me : " + inputMessage.value + "\n";
			webSocket.send(inputMessage.value);
			inputMessage.value = "";
			//$("inputBtn").attr("active")
			//$("inputBtn").prop("active")
			
			//스크롤바 자동 내리기 
			const top = $('#messageWindow').prop('scrollHeight');
			$('#messageWindow').scrollTop(top);
			//----------------
		
		}

	})

	
	
	
	
