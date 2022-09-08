<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="board-detail board-title text-secondary mb-5">
					<span>건의사항 글 작성</span>
				</div>
				<div class="w-100"></div>
				<input class="board-detail board-title" type="text" id="title" placeholder="제목 을 작성 하세요">
				<hr />
				<div class="row">
					<div class="col-md-6">
						<div class="blog__details">
							<div class="thumb-list-profile">
								<img src="${path}/resources/img/member/thumbnail/${user.img}" />
								<span class="text-white" >${user.nickname}</span>
								<input type="text" id="memberId" hidden="true" value="${user.id}">
								<input type="text" id="nickname" hidden="true" value="${user.nickname}">
								<input type="text" id="origin" hidden="true" value="${board.origin}">
							</div>
						</div>
					</div>
				<div class="col-md-6 text-white"
						style="line-height: 50px; text-align: right">2022-08-22</div>
				</div>
				<div class="spad">
				<textarea id="editor" class="col-md-6 form-control"
						style="resize: none;" placeholder="내용을 작성하세요.">
				</textarea>
				</div>
				
				<div class="w-100"></div>

				<div class="blog__details__btns">
					<div class="row justify-content-between">
						<div class="col-md float-left">
							<button type="button" class="btn btn-danger" onclick="location.href='${path}/boards/suggest'">목록</button>

						</div>
						<div class="col-md">
							<div class="btn-group float-right" role="group">
								<button class="btn btn-danger ml-3" id="sugsubmit">작성 완료</button>
								<button class="btn btn-secondary ml-3" id="back">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>

<script>
	var ckeditor_config = {
			resize_enabled : false,
			enterMode : CKEDITOR.ENTER_BR,
			shiftEnterMode : CKEDITOR.ENTER_P,
			height : 600,
			autoGrow_minHeight: 600,
			autoGrow_maxHeight: 5000,
			removePlugins : 'resize'
	};

	CKEDITOR.replace('editor', ckeditor_config);
	
	function check(){
		// ckeditor 내부의 텍스트를 가져오는 방법
		let innerContent = CKEDITOR.instances.editor.getData();
		return innerContent;
		// ckeditor 내부에 텍스트를 넣는 방법
		// CKEDITOR.instances.editor2.setData(innerContent);
	}
	
	$("#sugsubmit").on('click', function(){
		var title=$("#title").val();
		var content = check();
		var origin = $("#origin").val();
		var memberId = $("#memberId").val();
		var nickname = $("#nickname").val();
		
		
		var param = {
				"memberId" : memberId,
				"title" : title,
				"content" : check(),
				"origin" : origin,
				"nickname" : nickname
			}
		
		if (title == "" || content == "") {
			alert("제목과 내용을 모두 입력해 주세요.");
		} else {
			$.ajax({
				type : 'POST',
				data : JSON.stringify(param),
				url : "${path}/boards/suggest/writeSubmit",
				dataType : "text",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					console.log(data +" <- bno");
					alert("건의사항 등록이 완료 되었습니다.");
					location.href = "${path}/boards/suggest";
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("등록 실패 : 관리자에게 문의해주세요");
				}
			});
		}
	});
	
	$("#back").on('click', function() {
		history.go(-1);
	});
	
</script>
