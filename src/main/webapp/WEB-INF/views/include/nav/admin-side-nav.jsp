<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
    
<!-- side bar -->
<div class="fixed-left">
	<ul class="nav flex-column side-nav-back">
	  <li class="nav-item">
	    <a class="nav-link disabled"><s:message code="text.admin"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/admin/members"><s:message code="nav.admin.members"/></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${param.path}/admin/profit"><s:message code="nav.admin.profit"/></a>
	  </li>
	</ul>
</div>