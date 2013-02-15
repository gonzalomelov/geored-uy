
function initializeMap(){
	var mapOptions = {
		center: new google.maps.LatLng(-34.83833, -56.19806),
		zoom: 8,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
	
	var marker = new google.maps.Marker({
		map: map,
		draggable: true,
		position: new google.maps.LatLng(-34.83833, -56.19806)
	});
	
	google.maps.event.addListener(marker, 'dragend', function(){
		var point = marker.getPosition();
		map.panTo(point);
		$('#addLocationForm\\:coordX').val(point.lat());
		$('#addLocationForm\\:coordY').val(point.lng());
		$('#addLocationForm\\:coordY').val(point.lng());
		alert('gonza');
		alert(document.getElementById('companyIdAux').value);
		document.getElementById('addLocationForm:companyId').value = document.getElementById('companyIdAux').value;
		alert(document.getElementById('addLocationForm:companyId').value);
		
	});
}

window.onload = initializeMap;