<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Vehicle Registration</h3>
	<table>
		<form:form action="vhclRegdUpd?ownerID=${ownerID}"
			modelAttribute="vRegdModelCmd">
			<tr>
				<td>&nbsp;Regd_Date&nbsp;</td>
				<td><form:input type="date" path="regdDate" /></td>
			</tr>
			<tr>
				<td>&nbsp;Regd_Center&nbsp;</td>
				<td><form:input path="regCenter" /></td>
			</tr>
			<tr>
				<td colspan="2"><Button style="color: DeepSkyBlue" type="submit">Submit</Button>
					<button style="color: FF4500" type="reset">Reset</button></td>
			</tr>
		</form:form>
	</table>
</body>
</html>