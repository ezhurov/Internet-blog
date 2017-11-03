<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "post" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onload="getLike(${selected.id})" onkeydown="clickCtrlEnter('selectedpost')">
	<form name="selectedpost" id="selectedpost" method="post" action="savecomment.html">
		<p>${selected.theme}</p>
		<p>${selected.post}</p>
		<c:if test="${existImage ne false}">
			<p><img src="getimage.html?postid=${selected.id}" width="189" height="255" /></p>
		</c:if>
		<p>${selected.userName} | ${selected.datatime} | <st:message code = "likes" /> <span id="likes" ></span> | 
		<a href="" onclick="addLike(${selected.id})"><st:message code = "like" /></a></p>
		<hr>
		
		<c:forEach items="${comments}" var="currentComment">
			<p align="right">${currentComment.comment}</p>
			<p align="right"><a href="deletecomment.html?commentid=${currentComment.id}&postid=${selected.id}" onclick="return confirmDeletion()" style="visibility: ${visibleDel}"><st:message code = "deletecomment" /></a>
			| ${currentComment.userName} | ${currentComment.datatime}</p>
			<hr>
		</c:forEach>
		
		<p><textarea name="comment" placeholder="<st:message code = "newcomment" />" cols="58" rows="5" required></textarea></p>
		<p><input type="submit" name="ok" id="ok" value="OK" style="height: 30px; width: 120px"></p>
	</form>	
</body>
</html>