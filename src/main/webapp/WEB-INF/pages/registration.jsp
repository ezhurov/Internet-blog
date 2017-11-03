<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "registration" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onkeydown="clickCtrlEnter('registration')">
	<form name="registration" id="registration" method="post" action="saveorvalidate.html">
		<table width=100%>
			<tr>
				<td width=10%><st:message code = "username" /></td> 
				<td><input type="text" name="username" id="username" size="20" maxlength="30" required> <span style="color:red"> ${errorusername} </span></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "password" /></td>
				<td><input type="password" name="password" id="password" size="20" maxlength="30" required><span style="color:red"> ${errorpassword} </span></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "email" /></td>
				<td><input type="email" name="email" id="email" required size="20" maxlength="30"><span style="color:red"> ${erroremail} </span></td>
			</tr>
			<tr>
				<td><st:message code = "rules" /></td>
				<td><textarea name="information" cols="58" rows="5" readonly>блаблабла</textarea></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="agree" value="agree" id="agree" required><label for="agree"><st:message code = "agree" /></label></td>
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