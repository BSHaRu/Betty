<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
    
<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	  <li class="nav-item">
	    <a class="nav-link disabled"><s:message code="text.staff"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/${user.id}"><s:message code="text.user.info"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/rentals"><s:message code="nav.rental.list"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/books"><s:message code="nav.staff.book.list"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/staff/books/new"><s:message code="btn.book.new"/></a>
	  </li>
	</ul>
</div>