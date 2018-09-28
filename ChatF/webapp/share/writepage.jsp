
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
<head>
	
		<link rel="stylesheet" href="../assets/css/main.css" />

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
           height: 300px;
           width: 300px;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #floating-panel {
        position: absolute;
        top: 10px;
        left: 25%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
    </style>
    
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>




<script>


function cancle_Btn(){
	var con_test = confirm("게시물 작성을 취소하시겠습니까?");
	if(con_test == true){
		location.replace('list_review.jsp');

		
	} 
	else if(con_test == false){

	}
}
</script>




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
	    function attachMap(lat, lng, address) {
        	//writeForm.title.value =lat +","+ lng;
        	
        	writeForm.lat.value = lat;
            writeForm.lng.value = lng;
           // writeForm.title.value = lat + "dddd" + lng;
            console.log(lat+","+lng);
            var url="https://maps.google.com/maps?width=100%&amp;height=600&amp;hl=en&amp;q="+address+"+()&amp;ie=UTF8&amp;t=&amp;z=14&amp;iwloc=B&amp;output=embed";
            document.getElementById("iframediv").innerHTML ="";
            console.log(url);
            document.getElementById("iframediv").innerHTML ="<iframe name='iframeMap' src='"+url+"' width='400' height='250' frameborder='0' style='border:0' allowfullscreen></iframe>";
            
        }
        
	      
	    </script>
	    

</head>
<body>
<div class="page-wrap">

			<jsp:include page="../common/navbar.jsp"></jsp:include>

			<!-- Main -->
				<section id="main">

					<!-- Header -->
						<header id="header">
							
						</header>

					<!-- Gallery -->
						<section id="galleries">

							<!-- Photo Galleries -->
							
								<div class="gallery">

									<!-- Filters -->
									
										<div>
										
										</div>
 <!----------------------- google map Modal -------------------------------------------->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title">FIND LOCATION</h4>
        </div>
        <div class="modal-body">  
          <!-- -여서부터 지도 -->
          <form name="mapForm" name="mapForm">
          	<input type="hidden" name="lat">
          	<input type="hidden" name="lng">
          </form>
         <iframe src="/map2.jsp" width=550 height=600></iframe>
          <!-- -여서부터 지도 -->
        </div>
        <div class="modal-footer">
         <!--  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          
        </div>
      </div>
      
    </div>
  </div>
 <!-------------------------------------------------------------------------------------------------->


	<h1>REVIEW WRITE</h1>
	<form name="writeForm" action="/ReviewServlet" method="post">
	<input type="hidden" name="info" value="addReview">
	<input type="hidden" name="lat">
    <input type="hidden" name="lng">
    AREA 
       <select name="area" id="area">
       <option value="101">KANTO</option>
       <option value="102">KANSAI</option>
       <option value="103">HOKKAIDO</option>
       <option value="104">KYUSYU</option>
       </select>    
    TAG   <select name="tag" id ="tag">
       <option value="201">TOURISM</option>
       <option value="202">GOURMET</option>
       </select>
	TITLE   <input type="text" name="title" SIZE="60" > 
   지도첨부
      <a data-toggle="modal" href="#myModal">OPEN MAP</a>
  		<textarea name="summernote" id="summernote"><div id="iframediv"></div></textarea>
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
  
  
  <script>
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 14, 
          center: {lat: 37.56647, lng: 126.977963}
        });
        var geocoder = new google.maps.Geocoder();

        document.getElementById('submit').addEventListener('click', function() {
          geocodeAddress(geocoder, map);
        });
      }
	  var latlngStr = "";
      function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            latlngStr = results[0].geometry.location;
            
            var lat = results[0].geometry.location.lat();
            var lng = results[0].geometry.location.lng();
            console.log('위도 : ' + lat + ' , 경도 : ' + lng);
            
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
             
            });
            
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
        
        
        
        
        
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJcHk8_kd6b3skfzz-FdR1BsiYh3e-ly0&callback=initMap">
    </script>
    			<p align="right">
								<input type="submit" id="writeBtn" name="reviewWrite"  value="WRITE">
							
								<input type="button" id="cancleBtn" name="rewrite"  onclick="cancle_Btn();" value="CANCLE" />
								
								</p>
    

</body>
</html>
