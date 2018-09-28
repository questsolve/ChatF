<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Geocoding Service</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
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
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}
</style>

</head>

<body>
	<div id="floating-panel">
		<input id="address" type="textbox" value="도쿄"> 
		<input id="submit" type="button" value="Geocode"> 
	</div>
	<div id="map"></div>
	<script>
    
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 14, 
          center: {lat: 35.726498, lng: 139.7289853}  //35.726498,139.7289853
        });
        var geocoder = new google.maps.Geocoder();

        document.getElementById('submit').addEventListener('click', function() {
          geocodeAddress(geocoder, map);
        });
      }
	  
      function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        alert(address);
        
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            latlngStr = results[0].geometry.location;
            
            var latPrm = results[0].geometry.location.lat();
            var lngPrm = results[0].geometry.location.lng();
            console.log('위도 : ' + latPrm + ' , 경도 : ' + lngPrm);
            
            
            //----------------부모창에  lat, lng, address 값 넣어주기
            parent.attachMap(latPrm, lngPrm, address);
            //-------------------------------------------------------
            
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
</body>
</html>