<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title><st:message code = "deleteusers" /></title>
	<c:url value="js/script.js" var="script"></c:url>
	<script src="${script}"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<table width=100%>
		<c:forEach items="${users}" var="user">
			<tr>
				<td width=10%>${user.username}</td>
				<td><a href="deleteuser.html?username=${user.username}" onclick="return confirmDeletion()"><st:message code = "deleteaccount" /></a></td>
			</tr>	
		</c:forEach>
	</table>	
</body>
</html>