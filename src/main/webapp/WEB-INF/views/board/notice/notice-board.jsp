<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<section>
	<div class="container-md spad">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<form id="boardForm">
					<div class="row justify-content-between">
						<div class="col-auto">
							<h2><s:message code="text.board.notice"/></h2>
						</div>
						<div class="col-auto">
							<select id="pageNumSelect" name="pageNumSelect">
								<option value="${pm.cri.perPageNum }">${pm.cri.perPageNum}개씩</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="20">20</option>
							</select>
						</div>
					</div>
					<div class="table-responsive">
						<div class="table-wrapper">
							<table class="table-data-list table-striped table-dark table-bordered table-hover">
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody id="tableBody">
                
								</tbody>
							</table>
						</div>
					</div>
				</form>
				<div class="row">
					<input type="button" value="글작성" id="notice-write" />
				</div>
				<div class="row justify-content-center">
					<div class="form-row">
						<ul class="pagination" id="pagination">
							
						</ul>
					</div>
					<div class="w-100"></div>
					<div class="col-6">
						<form id="searchTypeForm">
							<div class="form-row input-group mb-3">
								<div class="input-group-prepend">
									<select id="searchType" name="searchType">
										<option ${pm.cri.searchType == 't' ? 'selected' : ''} value="t">제목</option>
										<option ${pm.cri.searchType == 'w' ? 'selected' : ''} value="w">작성자</option>
										<option ${pm.cri.searchType == 'c' ? 'selected' : ''} value="c">내용</option>
									</select>
								</div>
								<input type="text" id="keyword" class="form-control" name="keyword" />
								<button type="submit" id="searchTypeBtn" class="btn btn-primary">검색하기</button>
								<div class="input-group-append"></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
</body>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
<script>
	$(function() {
		searchList(1);
	});

	function searchList(pageNum) {
		var keyword = $("#keyword").val();
		var searchType = $("#searchType").val();
		var page = pageNum;
		var perPageNum = $("#pageNumSelect").val();
		if (keyword == null) {
			keyword = "";
		}

		console.log(keyword + ":" + searchType + ":" + perPageNum);

		$.ajax({
			type : 'get',
			url : "${path}/boards/notice/noticeList",
			data : {
				keyword : keyword,
				searchType : searchType,
				perPageNum : perPageNum,
				page : pageNum
			},
			dataType : 'json',
			success : function(result) {
				noticeList(result.list);
				noticePage(result.pm);
			}
		});
	}
	function noticeList(list) {
		var html = "";
		$(list).each(function() {
			var bno = this.bno;
			var nickname = this.nickname;
			var regdate = this.regdate;
			var title = this.title;
			var viewcnt = this.viewcnt;
			html += "<tr onclick=\"location.href='${path}/boards/notice/noticeDetail?bno=" + bno + "'\">";
			html += "<td>" + bno + "</td>";
			html += "<td>" + title + "</td>";
			html += "<td>" + nickname + "</td>";
			html += "<td>" + regdate + "</td>";
			html += "<td>" + viewcnt + "</td>";
			html += "</tr>";
		});
		$("#tableBody").html(html);

	}
	
	function noticePage(pm) {
		var str = "";
		if (pm.prev) {
			str += "<li><a href='" + (pm.startPage - 1) + "'> << </a></li>";
		}

		for (var i = pm.startPage; i <= pm.endPage; i++) {
			if (pm.cri.page == i) {
				str += "<li><a href='" + i + "' class='active'>" + i
						+ "</a></li>";
			} else {
				str += "<li><a href='" + i + "'>" + i + "</a></li>";
			}
		}

		if (pm.next) {
			str += "<li><a href='" + (pm.endPage + 1) + "'> >> </a></li>";
		}

		$("#pagination").html(str);
	}
	
	$("#pagination").on("click", "li a", function(e) {
		e.preventDefault();
		var commentPage = $(this).attr("href");
		let p = commentPage;
		searchList(p);
	});
	
</script>
