      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="header">
			
			<h1  ><a href="${pageContext.request.contextPath }">
			
			<img src="${pageContext.request.contextPath }/assets/images/mysite.png" width="100" height="50" />

			</a>
			</h1>
			<ul>
			<c:choose>
				<c:when test="${empty authUser }">
				<li><a href="${pageContext.request.contextPath }/user/loginform">LOG IN</a><li>
				<li><a href="${pageContext.request.contextPath }/user/joinform">SIGN UP</a><li>
				</c:when>
				<c:otherwise>
				<li><a href="${pageContext.request.contextPath }/user/modifyform">EDIT INFO.</a><li>
				<li><a href="${pageContext.request.contextPath }/user/logout">LOG OUT</a><li>
				<li>${authUser.name }님 반갑습니다 :)</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>