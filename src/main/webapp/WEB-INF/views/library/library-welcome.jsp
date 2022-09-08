<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<section>
	<div class="container-md spad">
		<div class="row">
			<div class="col-md-2">
			</div>
			<div class="col-md-8 justify-content-center">
				<div>
					세계에 단 하나뿐인 Betty.
					<br/>
					그곳으로 당신을 초대합니다.
				</div>
				<%@include file="/WEB-INF/views/library/fragment/library-use-time.jsp" %>
				<%@include file="/WEB-INF/views/library/fragment/library-facility.jsp" %>
				<%@include file="/WEB-INF/views/library/fragment/library-room.jsp" %>
				<%@include file="/WEB-INF/views/library/fragment/library-membership.jsp" %>
				<%@include file="/WEB-INF/views/library/fragment/library-route.jsp" %>
			</div>
			<div class="col-md-2">
			</div>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/views/include/footer.jsp"%>
</html>
