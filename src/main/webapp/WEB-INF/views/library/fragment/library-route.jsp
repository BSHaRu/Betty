<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div class="container-md">
		<div class="row">
			<div class="col-md-8 membership_title center-block ">
				<!-- 오시는 길 (지도, 로드뷰)-->
				<!-- 도메인이 로컬 호스트로 되어있습니다, 사이트 도메인이 생성되면 사이트주소에맞게 키 를 새로 발급받아야 함. -->
				<h2>오시는 길</h2><br/>
				<div id="map" style="width: 900px; height: 550px;"></div>
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d2d627d342f7e95fdb4c15682d4ebc7c"></script>

				<div id="roadview" style="width: 900px; height: 450px;"></div>

				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d2d627d342f7e95fdb4c15682d4ebc7c"></script>

				<h3 style="color: #fafafa">부산 동래구 충렬대로 84 영남빌딩 9층</h3>
			</div>
		</div>
	</div>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div -map
	mapOption = {
		center : new kakao.maps.LatLng(35.207388, 129.0702733), // 지도의 중심좌표
		level : 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성

	var markerPosition = new kakao.maps.LatLng(35.207388, 129.0702733);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});
	var circle = new kakao.maps.Circle({
		center : new kakao.maps.LatLng(35.207388, 129.0702733), // 원의 중심좌표 입니다 
		radius : 15, // 미터 단위의 원의 반지름입니다 
		strokeWeight : 3, // 선의 두께입니다 
		strokeColor : '#75B8FA', // 선의 색깔입니다
		strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		strokeStyle : 'dashed', // 선의 스타일 입니다
		fillColor : '#CFE7FF', // 채우기 색깔입니다
		fillOpacity : 0.7
	// 채우기 불투명도 입니다   
	});
	// 지도에 원을 표시합니다 
	circle.setMap(map);

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

	var iwContent = '<div style="padding:5px;"> 주주 사립 도서관 <br><br><a href="https://map.kakao.com/link/map/사립 도서관,35.207388, 129.0702733" style="color:blue" target="_blank">큰 지도 | </a> <a href="https://map.kakao.com/link/to/Hello World!,35.207388, 129.0702733" style="color:blue" target="_blank">길찾기</a></div>',

	iwPosition = new kakao.maps.LatLng(35.207388, 129.0702733); //인포윈도우 표시 위치입니다

	// 인포 윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
		position : iwPosition,
		content : iwContent
	});

	infowindow.open(map, marker);

	var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
	var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
	var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

	var position = new kakao.maps.LatLng(35.207590, 129.070116);

	// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
	roadviewClient.getNearestPanoId(position, 50, function(panoId) {
		roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
	});
</script>

</html>