<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- 로그인 화면 윗 공간 -->
	<div class="container-md spad">
		<div class="row">
			<div class="col-md-12 text-center">
					<h2>환영합니다!</h2>
			</div>
		</div>
	</div>

<!-- Login Section Begin -->
<section class="login">
	<div class="container-md">
		<div class="row justify-content-center">
			<div class="login__form">
				<form method="post">
					<div class="list-group justify-content-center">
						아이디
						<div class="input__item">
							<input type="text" name="id" placeholder="아이디"> <span
								class="icon_profile"></span>
						</div>
						비밀번호
						<div class="input__item">
							<input type="password" name="pw" placeholder="비밀번호"> <span
								class="icon_lock"></span>
						</div>
						<div class="form-check" style="width: 100%; text-align: center">
							<input class="form-check-input" type="checkbox" name="loginCookie"
								id="loginCookie"> <label class="form-check-label"
								for="loginCookie">로그인시 쿠키 저장</label>
						</div>

						<!-- 버튼 크기 == input__itme 크기 -->
						<div class="row justify-content-center">
							<button type="submit" class="common-btn btn" style="width: 50%">로그인</button>
						</div>
					</div>
				</form>
				<!-- login form의 right 정렬 -->
				<ul
					class="d-none list-group list-group-horizontal-md justify-content-center">
					<li class="list-group-item"><a data-toggle="modal"
						data-target="#idFindModal">아이디 찾기</a></li>
					<li class="list-group-item"><a data-toggle="modal"
						data-target="#passFindModal">비밀번호 찾기</a></li>
				</ul>
			</div>
		</div>

		<!-- idFind Modal -->
		<div class="modal fade" id="idFindModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">아이디 찾기</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="false">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- 입력태그 하나 -->
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">이름</div>
							</div>
							<input type="text" class="form-control" name="name">

						</div>
						
						<div class="input-group mt-3">
						  <div class="input-group-prepend">
						    <span class="input-group-text">전화번호</span>
						  </div>
						  <input type="text" class="form-control" name="phone">
						  <button class="form-control" id="idFindModalPhoneCheck">인증하기</button>
						</div>
						
						<div class="input-group mt-3" style="display: flex" id="idCodeWrap">
							<div class="input-group-prepend">
							    <span class="input-group-text">인증번호</span>
							  </div>
							<input type="text" class="form-control phone-code" />
							<input type="button" class="form-control acceptCode" value="인증" />
						</div> 
						
						<br />
						<!-- 입력태그 하나 -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">확인</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		<!-- id Find Modal/ -->


		<!-- passFindModal -->
		<div class="modal fade" id="passFindModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">비밀번호 찾기</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="false">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- 입력태그 하나 -->
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<div class="input-group-text">아이디</div>
							</div>
							<input type="text" class="form-control" name="id">
						</div>
						
						<!-- 입력태그 하나 -->
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<div class="input-group-text" id="passFindInputPass">전화번호
								</div>
							</div>

							<input type="text" class="form-control" name="phone">
							<button id="idFindModalPhoneCheck">인증하기</button>

						</div>
						<!-- 입력태그 하나 -->
						<div class="input-group mt-3" style="display: flex" id="pwCodeWrap">
							<div class="input-group-prepend">
							    <span class="input-group-text">인증번호</span>
							  </div>
							<input type="text" class="form-control phone-code" />
							<input type="button" class="form-control acceptCode" value="인증" />
						</div> 
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
						data-toggle="modal"
						data-target="#updatePwModal"
						data-dismiss="modal"
						>확인</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		<!-- passFind modal/ -->
		
		
		<!-- updatePwModal -->
		<div class="modal fade" id="updatePwModal" data-backdrop="static"
			tabindex="-1" role="dialog"	aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-scrollable modal-dialog-centered"
				role="document">
				
				<div class="modal-content">
				
					<div class="modal-header">
						<h5 class="modal-title">비밀번호 변경</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="false">&times;</span>
						</button>
					</div>
					<form class="form-group" action="${path}/members/num/edit" method="post">
						<div class="modal-body">
							<!-- 입력태그 하나 -->
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">아이디</div>
								</div>
								<input type="text" class="form-control" name="id" id="id">
							</div>
							
							<!-- 입력태그 하나 -->
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">비밀번호</div>
								</div>
								<input type="text" class="form-control" name="pw" id="pw">
							</div>
							
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<div class="input-group-text">비밀번호 확인</div>
								</div>
								<input type="text" class="form-control" id="repw">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary">확인</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- updatePwModal/ -->



	</div>
</section>
<!-- Login Section End -->

<%@include file="/WEB-INF/views/include/footer.jsp"%>

<script>
	if("${message}" != ""){
		alert("${message}");
	}
$(function(){
	
	$('#sendSMS').removeAttr('hidden');
	
	
	
	// 인증을 눌렀을 때 인증번호가 일치한다면
	// 현재 modal을 종료하고
	// 비밀번호 변경 modal을 show
	// 이때 적혀있던 id 값을 가져간다.
	// 여기에 검증 로직이 새로 나타나야한다.
	
	function onUpdatePwModal(){
		
	}
	
});
</script>
