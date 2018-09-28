<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
    </head>
    <body>
        <label for="locationTextField">Location</label>
        <input id="locationTextField" type="text" size="50">
         
        <script>
            function init() {
                var input = document.getElementById('locationTextField');
                var autocomplete = new google.maps.places.Autocomplete(input);
            }
 
            google.maps.event.addDomListener(window, 'load', init);
            
            function initMap() {
           var myLatlng = new google.maps.LatLng(35.737402,138.083448);
          	  var mapOptions = {
          	    zoom: 5,
          	    center: "seoul"
          	  }
         
              var map = new google.maps.Map(document.getElementById("map"), mapOptions);
              var marker = new google.maps.Marker({
                  position: myLatlng,
                  title:"Hello World!"
              });


              // To add the marker to the map, call setMap();
              marker.setMap(map); 
              
            }
        </script>
    </body>
</html>