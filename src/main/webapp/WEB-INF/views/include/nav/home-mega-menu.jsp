<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="collapse navbar-collapse">
	<!-- 펼치기위한 트리거 -->
	<a class="nav-link dropdown-toggle" href="#"
		id="servicesDropdown" role="button" data-toggle="dropdown"
		aria-haspopup="true" aria-expanded="false"><s:message code="text.megamenu"/></a>


	<!-- 펼쳐져서 생긴 공간에 들어갈 것들 -->
	<div class="dropdown-menu dropdown-menu-left"
		aria-labelledby="servicesDropdown">
		<div class="d-md-flex align-items-start justify-content-start"  style="text-align:center; ">
			<div class="col-md-4">
				<br/>
				sign
				<a class="dropdown-item" href="${path}/sign/in">로그인</a>
				<a class="dropdown-item" href="${path}/sign/up">회원가입 선택</a>
				<a class="dropdown-item" href="${path}/sign/up/member">회원가입</a>
				<a class="dropdown-item" href="${path}/sign/up/staff">직원 회원가입</a> 
				 
				<br/>
				
				member
				
				<a class="dropdown-item" href="${path}/members/${user.id}/dashboard">대시보드</a>
				<a class="dropdown-item" href="${path}/members/${user.id}/charge">포인트충전</a> 
				<a class="dropdown-item" href="${path}/members/${user.id}">회원정보</a>
				<a class="dropdown-item" href="${path}/members/${user.id}/rentals">대여이력</a> 
				
				<br/>
				
				book 
				<a class="dropdown-item" href="${path}/books/9772383984000">책 상세보기</a> 
				<a class="dropdown-item" href="${path}/books">책 리스트</a>
				
				<br/>
				
				offline
				<a class="dropdown-item" href="${path}/offline">오프라인</a>
			</div>
			
			<div class="col-md-4">
				<br/>
				staff
				<a class="dropdown-item" href="${path}/staff">직원 영역</a>
				<a class="dropdown-item" href="${path}/staff/members">회원 정보 조회</a>
				<a class="dropdown-item" href="${path}/staff/${user.id}">직원 회원정보</a>
				
				<a class="dropdown-item" href="${path}/staff/${user.id}/edit">회원 정보 수정</a>
				
				<a class="dropdown-item" href="${path}/staff/books/">도서 현황</a>
				
				<a class="dropdown-item" href="${path}/staff/books/new">도서 입고</a>
				<a class="dropdown-item" href="${path}/staff/books/9772383984000/edit">도서 정보 수정</a>
				
				<a class="dropdown-item" href="${path}/staff/rentals/">도서 대여 현황 및 예약 정보</a>

				<br/>
				admin
				<a class="dropdown-item" href="${path}/admin/members/">관리자 회원정보 확인</a>
				<br/>
				library
				<a class="dropdown-item" href="${path}/library/">도서관 소개</a>
			</div>
			
			<div class="col-md-4">
				<br/>
				board
				<a class="dropdown-item" href="${path}/boards/free">자유게시판</a> 
				<a class="dropdown-item" href="${path}/boards/suggest/">건의사항</a> 
				<a class="dropdown-item" href="${path}/boards/notice">공지사항</a> 
			  	<a class="dropdown-item" href="${path}/boards/free/1">자유게시판 상세보기</a> 
			  	<a class="dropdown-item" href="${path}/boards/free/new">자유게시판 등록</a> 
			  	<a class="dropdown-item" href="${path}/boards/free/num/edit">자유게시판 수정</a> 
			  	<a class="dropdown-item" href="${path}/boards/suggest/1">건의사항 상세보기</a> 
			  	<a class="dropdown-item" href="${path}/boards/suggest/new">건의사항 등록</a> 
			  	<a class="dropdown-item" href="${path}/boards/suggest/1/edit">건의사항 수정</a> 
			  	<a class="dropdown-item" href="${path}/boards/notice/1">공지사항 상세보기</a> 
			  	<a class="dropdown-item" href="${path}/boards/notice/new">공지사항 등록</a> 
			  	<a class="dropdown-item" href="${path}/boards/notice/1/edit">공지사항 수정</a> 
			  	<a class="dropdown-item" href="${path}/admin/profit">도서관 수익</a> 
			  	editor ex
			  	<a class="dropdown-item" href="${path}/edit">에디터 견본</a> 
			  	<a class="dropdown-item" href="${path}/knh">캘린더 연습</a> 
			</div>
		</div>
	</div>
</div>