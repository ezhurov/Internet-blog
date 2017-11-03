<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "changepassword" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body onkeydown="clickCtrlEnter('changepassword')">
	<form name="changepassword" id="changepassword" method="post" action="savepassword.html">
		<table width=100%>
			<tr>
				<td width=10%><st:message code = "oldpassword" /></td>
				<td><input type="password" name="oldpassword" id="oldpassword" size="20" maxlength="30" required> <span style="color:red"> ${erroroldpassword} </span></td>
			</tr>
			<tr>
				<td width=10%><st:message code = "password" /></td>
				<td><input type="password" name="password" id="password" size="20" maxlength="30" required> <span style="color:red"> ${errorpassword} </span></td>
			</tr>
			<tr>
				<td><input type="submit" name="ok" id="ok" value="OK" style="height: 30px; width: 120px"></td>
			</tr>
		</table>
	</form>
</body>
</html>