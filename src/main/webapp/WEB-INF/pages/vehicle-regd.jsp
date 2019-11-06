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
		<form:form action="vhclRegd?ownerID=${ownerID}"
			modelAttribute="vRegdModelCmd">
			<tr>
				<td>&nbsp;Reg Date&nbsp;</td>
				<td><form:input type="date" path="regdDate" /></td>
			</tr>
			<tr>
				<td>&nbsp;Reg Center&nbsp;</td>
				<td><form:input path="regCenter" /></td>
			</tr>
			<tr>
				<td colspan="2"><Button type="submit" style="background-color: #00BFFF; color: white;">Submit</Button> <a
					href="vhclDtlsUpd?ownerID=${ownerID}"><button type="button"  style="background-color: #FF7F50">previous</button></a>
					<button type="reset" style="background-color: #FF4500; color: white;">Reset</button></td>
			</tr>
		</form:form>
	</table>
</body>
</html>