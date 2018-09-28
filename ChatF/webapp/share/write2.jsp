<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Gallery - Snapshot by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../assets/css/main.css" />
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.js"></script>
    
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
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
										<h1>REVIEW WRITE</h1>
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
	<b>TITLE</b>   <input type="text" name="title" SIZE="60" > 
        지도첨부
      <a data-toggle="modal" href="#myModal">Open Modal</a>
	  <div id="summernote"><div id="iframediv"></div>
    <script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 800
      });
    </script>
  

								</div>
								<p align="right">
								<input type="button" name="rewri"  value="WRITE">
								<input type="button" name="rewrite"  value="CANCLE" onCick="ddd.jsp">
								</p>
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
		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/jquery.poptrox.min.js"></script>
			<script src="../assets/js/jquery.scrolly.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>

	</body>
</html>