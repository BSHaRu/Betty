<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<!-- Blog Details Section Begin -->
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="board-detail board-title text-secondary">
					<span>공지사항</span>
				</div>
				<div class="w-100"></div>
				<input class="board-detail board-title" type="text" value="${noticeBoard.title }" readonly>
				<hr />
				<div class="row">
					<div class="col-md-6">
						<div class="blog__details">
							<div class="thumb-list-profile">
								<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" />
								<span class="text-white">${noticeBoard.memberId }</span>
							</div>
						</div>
					</div>
					<div class="col-md-6 text-white"
						style="line-height: 50px; text-align: right">${noticeBoard.regdate }</div>
				</div>
				<div class="spad-sm">
						<c:out value="${board.content}" escapeXml="false"></c:out>
				</div>
				<div class="w-100"></div>

				<div class="blog__details__btns">
					<div class="row justify-content-between">
						<div class="col-md float-left">
							<button type="button" class="btn btn-danger notice-list">목록</button>

						</div>
						<div class="col-md">
							<div class="btn-group float-right" role="group">
								
								<button class="btn btn-danger notice-modify">수정</button>
								<button class="btn btn-secondary ml-3 notice-delete">삭제</button>
							</div>
						</div>
						<form id="detail-form" method="get">
							<input type="hidden" name="bno" value="${noticeBoard.bno }" />
							<input type="hidden" name="page" value="${cri.page }" />
							<input type="hidden" name="perPageNum" value="${cri.perPageNum }" />
							<input type="hidden" name="searchType" value="${cri.searchType }" />
							<input type="hidden" name="keyword" value="${cri.keyword }" />
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</section>


<%@include file="/WEB-INF/views/include/footer.jsp"%>

</html>

<script>
	/* $(document).ready(function (){
		var ta = $("#textArea");
		ta.css('height','auto');
		var taH = ta.prop('scrollHeight');
		ta.css('height', taH);
	}); */
	
	var formObj = $("#detail-form");
	
	$(".notice-modify").click(function(){
		formObj.attr("action","${path}/boards/notice/${bno}/edit");
		formObj.submit();
	});
	
	$(".notice-delete").click(function(){
		var isDelete = confirm("게시글을 삭제 하시겠습니까?");
		if(isDelete){
			formObj.attr("action","${path}/boards/notice/${bno}");
			formObj.attr("method","POST");
			formObj.submit();
		}else{
			alert('취소됨');
		}
	});
	
	$(".notice-list").click(function(){
		formObj.attr("action","${path}/boards/notice");
		formObj.submit();
	});
	
</script>