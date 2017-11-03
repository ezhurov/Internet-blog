<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "account" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onkeydown="clickCtrlEnter('account')">
	<form name="account" id="account" method="post" action="savepersonaldata.html">
		<p align="left"><a href="changepassword.html"><st:message code = "changepassword" /></a> &nbsp 
		<a href="deleteaccount.html" onclick="return confirmDeletion()"><st:message code = "deleteaccount" /></a> &nbsp
		<a href="deleteusers.html" style="visibility: ${visible}"><st:message code = "deleteusers" /></a></p>
		
		<table width=100%>
			<tr>
				<td width=10%><st:message code = "surname" /></td> 
				<td><input type="text" name="surname" id="surname" value="${personaldata.surname}" size="20" maxlength="30"></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "name" /></td>
				<td><input type="text" name="name" id="name" value="${personaldata.name}" size="20" maxlength="30"></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "patronymic" /></td>
				<td><input type="text" name="patronymic" id="patronymic" value="${personaldata.patronymic}" size="20" maxlength="30"></td>
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