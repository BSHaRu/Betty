<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!-- Blog Details Section Begin -->
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="board-detail board-title text-secondary">
					<span>건의사항</span>
				</div>
				<div class="w-100"></div>
				<input class="board-detail board-title" type="text" value="${board.title}" readonly>
				<hr />
				<div class="row">
					<div class="col-md-6">
						<div class="blog__details">
							<div class="thumb-list-profile">
								<img src="${path}/resources/img/member/thumbnail/${memberImg}" /> <span class="text-white">"${board.memberId}"</span>
							</div>
						</div>
					</div>
					<div class="col-md-6 text-white" style="line-height: 50px; text-align: right">${board.regdate}</div>
				</div>
				<div class="spad-sm" style="background-color: gray; border-radius: 5px;">
					<c:out value="${board.content}" escapeXml="false"></c:out>
				</div>
				<div class="row justify-content-center mb-5">
					<button type="button" class="btn btn-danger">
						<i class="fa fa-heart-o"></i> ${board.recommend}
					</button>
				</div>
				<div class="w-100"></div>
				<div class="blog__details__btns">
					<div class="row justify-content-between">
						<div class="col-md float-left">
							<button type="button" class="btn btn-danger" onclick="location.href='${path}/boards/suggest'">목록</button>
						</div>
						<div class="col-md">
							<div class="btn-group float-right" role="group">
								<button class="btn btn-danger" onclick="location.href='${path}/boards/suggest/sugedit?bno=${board.bno}'">수정</button>
								<button class="btn btn-secondary ml-3" id="delete">삭제</button>
							</div>
							<input type="text" id="bno" value="${board.bno}" hidden="true" />
							<input type="text" id="memberId" value="${board.memberId}" hidden="true" />
							<input type="text" id="title" value="${board.title}" hidden="true" />
							<input type="text" id="content" value="${board.content}" hidden="true" />
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
	$(document).ready(function() {
		var ta = $("#textArea");
		ta.css('height', 'auto');
		var taH = ta.prop('scrollHeight');
		ta.css('height', taH);
	});

	$("#delete").click(function() {
		console.log("delete Click");
		var isDelete = confirm("건의 사항을  삭제하시겠습니까?");
		var bno = $("#bno").val();
		var memberId = $("#memberId").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var param = {
			"bno" : bno,
			"memberId" : memberId,
			"title" : title,
			"content" : content
		}
		if (isDelete) {
			console.log("delete Call -" + bno);
			console.log(bno + ":" + memberId + ":" + title + ":" + content);
			$.ajax({
				type : 'POST',
				data : JSON.stringify(param),
				url : "${path}/boards/suggest/delete",
				dataType : "text",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					alert("삭제 처리 되었습니다 , " + data);
					location.href = "${path}/boards/suggest";
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("삭제실패, 관리자에게 문의 해주세요 error-" + jqXHR + " : " + textStatus + " : " + errorThrown);
				}
			});

		} else {
			alert('삭제 요청이 취소되었습니다');
		}
	});
</script>