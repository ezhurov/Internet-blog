<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "index" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<p><a href="account.html"><st:message code = "account" /></a> &nbsp
	<a href="newtheme.html"><st:message code = "newtheme" /></a> &nbsp
	<a href="search.html"><st:message code = "search" /></a> &nbsp
	<a href="about.html"><st:message code = "about" /></a> &nbsp
	<a href="<c:url value="logout" />"><st:message code = "exit" /></a></p>
	<hr>
	
	<c:forEach items="${posts}" var="post">
		<p>${post.theme}</p>
		<p>${post.post}</p>
		<p><a href="selectedpost.html?postid=${post.id}" target="_blank"><st:message code = "read" /></a></p>
		<p>${post.userName} | ${post.datatime} | <st:message code = "likes" /> ${post.likes} |
		<a href="deletepost.html?postid=${post.id}" onclick="return confirmDeletion()" style="visibility: ${visible}"><st:message code = "deletepost" /></a></p>
		<hr>
	</c:forEach>
</body>
</html>