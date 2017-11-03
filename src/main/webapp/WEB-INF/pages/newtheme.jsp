<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "newtheme" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onkeydown="clickCtrlEnter('newtheme')">
	<form name="newtheme" id="newtheme" method="post" action="addtheme.html" enctype="multipart/form-data">
		<table width=100%>
			<tr>
				<td width=10%><st:message code = "theme" /></td>
				<td><input type="text" name="theme" id="theme" required size="20" maxlength="30"><span style="color:red"> ${errortheme} </span></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "post" /></td>
				<td><textarea name="post" placeholder="<st:message code = "entermessage" />" cols="58" rows="5"></textarea></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "file" /></td>
				<td><input type="file" name="file" id="file" accept="image/*"></td>
			</tr>
			<tr>
				<td><input type="submit" name="ok" id="ok" value="OK" style="height: 30px; width: 120px"></td>
			</tr>
		</table>
		
		<div align="center" style="position: fixed; left: 0; bottom: 0; background: white; padding: 0px; color: black; width: 100%;">
			<p><a href="index.html"><st:message code = "courseproject" /></a></p>
		</div>
	</form>
</body>
</html>