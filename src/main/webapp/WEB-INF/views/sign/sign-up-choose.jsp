<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<section class="container-md spad">
	<div class="row justify-content-center spad">
	<button type="button" class="btn btn-danger btn-lg mr-2" onclick="location.href='${path}/sign/up/member'" value="일반회원">일반회원</button>
	<button type="button" class="btn btn-secondary btn-lg ml-2" onclick="location.href='${path}/sign/up/staff'" value="직원">직원</button>
	</div>
</section>
<%@include file="/WEB-INF/views/include/footer.jsp"%>