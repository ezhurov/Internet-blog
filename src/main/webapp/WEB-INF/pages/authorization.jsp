<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "authorization" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onkeydown="clickCtrlEnter('authorization')">
	<form name="authorization" id="authorization" method="post" action="<c:url value="/login" />">
		<p align="left"><a href="?lang=en">en</a> &nbsp <a href="?lang=ru">ru</a> &nbsp 
		<a href="registration.html"><st:message code = "registration" /></a> &nbsp
		<a href="forgotpassword.html"><st:message code = "forgotpassword" /></a></p>
		
		<table width=100%>
			<tr>
				<td width=10%><st:message code = "username" /></td> 
				<td><input type="text" name="username" id="username" size="20" maxlength="30" required> <span style="color:red"> ${error} </span></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "password" /></td>
				<td><input type="password" name="password" id="password" size="20" maxlength="30" required></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="remember-me" id="remember-me"><label for="remember-me"><st:message code = "remember" /></label></td>
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