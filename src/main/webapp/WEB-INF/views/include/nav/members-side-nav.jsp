<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
    
<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	   <li class="nav-item">
	    <a class="nav-link disabled" href="#"><s:message code="nav.member"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}/dashboard"><s:message code="text.dashboard"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}/charge"><s:message code="nav.member.point"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}/rentals"><s:message code="nav.rental.list"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/members/${user.id}"><s:message code="text.user.info"/></a>
	  </li>
	</ul>
</div>