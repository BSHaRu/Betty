<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	<li class="nav-item">
	    <a class="nav-link disabled"><s:message code="text.board"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/boards/notice"><s:message code="text.board.notice"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/boards/free"><s:message code="text.board.free"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/boards/suggest"><s:message code="text.board.suggest"/></a>
	  </li>
	</ul>
</div>