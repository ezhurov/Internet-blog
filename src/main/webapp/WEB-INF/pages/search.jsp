<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "search" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onkeydown="clickCtrlEnter('search')">
	<form name="search" id="search" method="post" action="searchresult.html">
		<p><input type="text" name="searchfor" id="searchfor" size="20" maxlength="30" required> <span style="color:red"> ${error} </span></p>
		<p><input type="radio" name="subject" id="theme" value="theme" checked><label for="theme"><st:message code = "theme" /></label>
		<input type="radio" name="subject" id="author" value="author"><label for="author"><st:message code = "author" /></label></p>
		<p><input type="submit" name="ok" id="ok" value="OK" style="height: 30px; width: 120px"></p>
		
		<c:forEach items="${posts}" var="post">
			<p>${post.theme}</p>
			<p>${post.post}</p>
			<p><a href="selectedpost.html?postid=${post.id}"><st:message code = "read" /></a></p>
			<p>${post.userName} (${post.datatime}) | <st:message code = "likes" /> ${post.likes} | 
			<a href="deletepost.html?postid=${post.id}" onclick="return confirmDeletion()" style="visibility: ${visible}"><st:message code = "deletepost" /></a></p>
			<hr>
		</c:forEach>
	</form>	
</body>
</html>