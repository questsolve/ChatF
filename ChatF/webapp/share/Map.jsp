<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
      <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="AIzaSyAKU9UGmNsdFNOmct3llevT0oD1AQgUozA" />

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
    <div id="map"></div>
    <script>
      var map;
      function initMap() {
    	  var myLatlng = new google.maps.LatLng(35.737402,138.083448);
    	  var mapOptions = {
    	    zoom: 5,
    	    center: myLatlng
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
        marker.setMap(map);
        
      }
    </script>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQkvWqRUl6S24GlrJxQy0A75JiT_bjyCY&callback=initMap"
    async defer></script>
  </body>
</html>