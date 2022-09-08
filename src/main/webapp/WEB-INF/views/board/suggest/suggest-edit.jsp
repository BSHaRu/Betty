<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%
    response.addHeader("Access-Control-Allow-Origin", "*");
response.addHeader("Access-Control-Allow-Credentials", "true");
%>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="board-detail board-title text-secondary mb-5">
					<span>건의사항 수정하기</span>
				</div>
				<div class="w-100"></div>
				<div class="row justify-content-between">
					<div class="col-md float-left">
						<input class="board-detail board-title" type="text" value="제목 : " readonly="readonly">
					</div>
					<div class="col-md float-right">
						<input class="board-detail board-title" id="sugTitle" type="text" value="${board.title}">
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-md-6">
						<div class="blog__details">
							<div class="thumb-list-profile">
								<img src="${path}/resources/img/member/thumbnail/${memberImg}" /> <span class="text-white">${board.memberId}</span>
							</div>
						</div>
					</div>
					<div class="col-md-6 text-white" style="line-height: 50px; text-align: right">작성 시간 : ${board.regdate }</div>
				</div>
				<div class="spad">
					<textarea id="editor" class="col-md-6 form-control" style="resize: none;" placeholder="내용을 작성하세요.">
				</textarea>
				</div>
				<div class="w-100"></div>
				<div class="blog__details__btns">
					<div class="row justify-content-between">
						<div class="col-md float-left"></div>
						<div class="col-md">
							<div class="btn-group float-right" role="group">
								<button class="btn btn-danger ml-3" id="submit" onclick="modifySuggest()">수정</button>
								<button class="btn btn-secondary ml-3" id="back">취소</button>
								<input type="text" id="path" value="${path}" hidden="true" />
								<input type="text" id="memberId" value="${board.memberId}" hidden="true" />
								<input type="text" id="bno" value="${board.bno}" hidden="true" />
								<input type="text" id="cont" value="${board.content}" hidden="true" />
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
	// 페이지 실행시 실행
	$(document).ready(function() {
		var content = $("#cont").val();
		CKEDITOR.instances.editor.setData(content);
	});

	var ckeditor_config = {
		resize_enabled : false,
		enterMode : CKEDITOR.ENTER_BR,
		shiftEnterMode : CKEDITOR.ENTER_P,
		height : 600,
		autoGrow_minHeight : 600,
		autoGrow_maxHeight : 5000,
		removePlugins : 'resize'
	};

	CKEDITOR.replace('editor', ckeditor_config);

	function modifySuggest() {

		var bno = $("#bno").val();
		var memberId = $("#memberId").val();
		var title = $("#sugTitle").val();
		var content = CKEDITOR.instances.editor.getData();
		var path = $("#path").val();

		var param = {
			"bno" : bno,
			"memberId" : memberId,
			"title" : title,
			"content" : content
		}

		if (title == "" || content == "") {
			alert("제목과 내용을 모두 입력해 주세요.");
		} else {
			$.ajax({
				type : 'POST',
				data : JSON.stringify(param),
				url : path + "/boards/suggest/sboardModify",
				dataType : "text",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					alert("수정이 완료 되었습니다.");
					location.href = path + "/boards/suggest/detail?bno=" + data;
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("수정 실패 : 관리자에게 문의해주세요");
				}
			});
		}
	}

	$("#back").on('click', function() {
		history.go(-1);
	});
</script>