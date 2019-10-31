<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Vehicle Registration Form</h3>
	<table>
		<form:form action="vhclRegd?ownerID=${ownerID}" modelAttribute="vRegdModelCmd">
			<tr>
				<td>&nbsp;Regd_Date&nbsp;</td>
				<td><form:input type="date" path="regdDate"/></td>
			</tr>
			<tr>
				<td>&nbsp;Regd_Center&nbsp;</td>
				<td><form:input path="regCenter" /></td>
			</tr>
			<tr><td ><Button type="submit">Submit</Button>
			<a href="vhclDtlsUpd?ownerID=${ownerID}"><button type="button">previous</button></a>
				</td></tr>
		</form:form>
	</table>
</body>
</html>