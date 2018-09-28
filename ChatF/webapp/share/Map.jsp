<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDJcHk8_kd6b3skfzz-FdR1BsiYh3e-ly0&libraries=places"></script>
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
      
    </style>
  </head>
  <body>
  <input id="locationTextField" type="text" size="50">
  
    <div id="map"></div>
    <script>
      var map;
      function initMap() {
    	  function init() {
              //var input = document.getElementById('locationTextField');
              var autocomplete = new google.maps.places.Autocomplete("독산동");
          }

          google.maps.event.addDomListener(window, 'load', init);
          
          
    	 /*  //var myLatlng = new google.maps.LatLng(35.737402,138.083448);
    	  var mapOptions = {
    	    zoom: 5,
    	    center: "seoul"
    	  }
   
        var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        var marker = new google.maps.Marker({
            position: myLatlng,
            title:"Hello World!"
        });

        var request = {
        	    query: 'Museum of Contemporary Art Australia',
        	    fields: ['photos', 'formatted_address', 'name', 'rating', 'opening_hours', 'geometry'],
        	  };

        // To add the marker to the map, call setMap();
        marker.setMap(map); */
        
      }
    </script>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQkvWqRUl6S24GlrJxQy0A75JiT_bjyCY&callback=initMap"
    async defer></script>
  </body>
</html>