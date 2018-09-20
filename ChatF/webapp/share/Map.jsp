<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
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
    </style>
  </head>
  <body>
<div id="searchbox" role="search" jstcache="90" class="searchbox searchbox-shadow noprint clear-button-shown " jsan="7.searchbox,7.searchbox-shadow,7.noprint,7.sbox-focus,7.directions-button-shown,7.searchbox-empty,0.id,0.role"> <form id="searchbox_form" onsubmit="return false;" class="initial-searchbox-wrapper"> <div class="gstl_50 sbib_a"><div class="sbib_d" id="sb_chc50" dir="ltr"></div><div class="gsst_b sbib_c" id="gs_st50" dir="ltr"></div><div class="sbib_b" id="sb_ifc50" dir="ltr"><div id="gs_lc50" style="position: relative;"><input autofocus="autofocus" value="" aria-label="Google 지도 검색" autocomplete="off" id="searchboxinput" name="q" jstcache="91" jsaction="keyup:omnibox.keyUp;input:omnibox.inputDetected" class="tactile-searchbox-input" jsan="7.searchboxinput,0.autofocus,0.value,0.placeholder,0.aria-label,0.autocomplete,0.id,0.name,22.jsaction" aria-haspopup="false" role="combobox" aria-autocomplete="list" dir="ltr" spellcheck="false" style="border: none; padding: 0px; margin: 0px; height: auto; width: 100%; background: url(&quot;data:image/gif;base64,R0lGODlhAQABAID/AMDAwAAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw%3D%3D&quot;) transparent; position: absolute; z-index: 6; left: 0px; outline: none;"><input class="tactile-searchbox-input" disabled="" autocomplete="off" autocapitalize="off" aria-hidden="true" id="gs_htif50" dir="ltr" style="border: none; padding: 0px; margin: 0px; height: auto; width: 100%; position: absolute; z-index: 1; background-color: transparent; -webkit-text-fill-color: silver; color: silver; transition: all 0.218s ease 0s; opacity: 0; text-align: left; left: 0px;"></div></div></div> </form> <div class="searchbox-searchbutton-container"> <button aria-label="검색" guidedhelpid="searchbutton" id="searchbox-searchbutton" jstcache="92" jsaction="omnibox.search;mouseover:omnibox.showTooltip;mouseout:omnibox.hideTooltip;focus:omnibox.showTooltip;blur:omnibox.hideTooltip" class="searchbox-searchbutton"></button> <span aria-hidden="true" jstcache="93" class="omnibox-tooltip tooltip-dark">검색</span> </div> <div jstcache="94" class="searchbox-directions-container" style="display: none;"> <button aria-label="길찾기" guidedhelpid="directions_icon" id="searchbox-directions" vet="11157" jstcache="95" jsaction="omnibox.showDirections;mousemove:omnibox.preloadDirections;mouseover:omnibox.showTooltip;mouseout:omnibox.hideTooltip;focus:omnibox.showTooltip;blur:omnibox.hideTooltip" class="searchbox-directions" jsan="7.searchbox-directions,0.ved,0.aria-label,0.guidedhelpid,0.id,0.vet,22.jsaction" ved="1i:3,t:11157,e:2,p:kO-iW8fSGZLu-QbEyY3oBw:1"></button> <span aria-hidden="true" class="omnibox-tooltip tooltip-dark">길찾기</span> </div> <a class="gsst_a" href="javascript:void(0)" style="" role="button" tooltip="검색결과 지우기" aria-label="검색결과 지우기" guidedhelpid="clear_search"><span class="sbcb_a" id="sb_cb50" aria-label="검색결과 지우기"></span></a></div>
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

        // To add the marker to the map, call setMap();
        marker.setMap(map);
      }
    </script>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQkvWqRUl6S24GlrJxQy0A75JiT_bjyCY&callback=initMap"
    async defer></script>
  </body>
</html>