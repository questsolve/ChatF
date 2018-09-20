
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
	<meta charset="uft-8" />
	<title>REVIEW WRITE</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
    
	<script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
	 	function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
	 		data = new FormData();
	 	    data.append("uploadFile", file);
	 	    $.ajax({ // ajax를 통해 파일 업로드 처리
	 	        data : data,
	 	        type : "POST",
	 	        url : "./summernote_imageUpload.jsp",
	 	        cache : false,
	 	        contentType : false,
	 	        processData : false,
	 	        success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
	 	        	$(editor).summernote('editor.insertImage', data.url);
	 	        }
	 	    });
	 	}
	</script>
</head>
<body>
	<h1>REVIEW WRITE</h1>
	<form name="writeForm" action="./summernote_insert.jsp" method="post">
	TITLE   <input type="text" name="title" SIZE="60" > 
    AREA   <form action="/action_page.php">
       <select name="cars">
       <option value="volvo">KANTO</option>
       <option value="saab">KANSAI</option>
       <option value="fiat">HOKKAIDO</option>
       <option value="audi">KYUSYU</option>
       </select>    
    TAG   <select name="cars">
       <option value="volvo">TOURISM</option>
       <option value="saab">GOURMET</option>
       
       </select>          
  
  
		<textarea id="summernote">Hello Summernote</textarea>
        <script>
            $(document).ready(function() {
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 400,
					callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
					    onImageUpload: function(files, editor, welEditable) {
						    sendFile(files[0], this);
						}
					}
				});
			});
		</script>
		  <script>

    $(document).ready(function() {

    	$('#nttCn').summernote({

    		   height: 800,   //set editable area's height

    		   callbacks: {

    		   		onImageUpload: function(image) {

						uploadImage(image[0]);

    		   		}

    		   },

               lang : 'ko-KR',

    		   placeholder: '이제 본문에 #을 이용한 태그 입력도 가능해요! URL을 통해, 사진 및 youtube를 등록할 수도 있어요!',

    		   codemirror: { // codemirror options

    		   theme: 'monokai'

    		  }

    	});    	

    });

    

    function uploadImage(image) {

        var data = new FormData();

        data.append("image", image);

        $.ajax({

            type: "post",

            cache: false,

            contentType:false,

            processData: false,

            dataType :'jsonp',

            url: '/cop/bbs/insertSummberNoteFile.do',

            data: data,

            success: function(data) {

//이미지 경로를 작성하면 됩니다 ^  ^

                var image = $('<img>').attr('src', '/cmm/fms/getImage.do?atchFileId='+data[0].atchFileId+'&fileSn=0');

                $('#nttCn').summernote("insertNode", image[0]);

            },

            error: function(data) {

            	alert('error : ' +data);

            }

        });

    }

  </script>
  
  <input type="button" name="dd" value="wirte">
</body>
</html>
