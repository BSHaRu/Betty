<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="blog__details__comment">
	<h4>총 2개의 댓글</h4>

	<div class="blog__details__comment__item">
		<div class="anime__review__item__pic">
			<img src="${path}/resources/img/member/thumbnail/profile_male.jpg" alt="">
		</div>
		<div class="blog__details__comment__item__text">
			<span>Sep 08, 2020</span>
			<h5>John Smith</h5>
			<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit
				amet, consectetur, adipisci velit, sed quia non numquam eius modi</p>
			<a href="#"><s:message code="btn.reply"/></a> <a href="#"><s:message code="delete"/></a>
		</div>
	</div>

	<div
		class="blog__details__comment__item blog__details__comment__item--reply">
		<div class="anime__review__item__pic">
			<img src="${path}/resources/img/member/thumbnail/profile_female.jpg" alt="">
		</div>
		<div class="blog__details__comment__item__text">
			<span>Sep 08, 2020</span>
			<h5>Elizabeth Perry</h5>
			<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit
				amet, consectetur, adipisci velit, sed quia non numquam eius modi</p>
			<a href="#"><s:message code="btn.reply"/></a> <a href="#"><s:message code="delete"/></a>
		</div>
	</div>

	<div class="blog__details__form">
		<h4><s:message code="textarea.comment"/></h4>
		<form action="#">
			<div class="row" style="display: block">
				<div class="col-md-12">
					<textarea placeholder="Message"></textarea>
					<button type="submit" class="site-btn"><s:message code="btn.reply"/></button>
				</div>
			</div>
		</form>
	</div>
</div>