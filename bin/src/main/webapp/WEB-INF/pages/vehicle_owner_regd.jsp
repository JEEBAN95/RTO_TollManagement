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
	<h3>Owner Details</h3>
	<table>
		<form:form action="vhclOnrRegister"
			modelAttribute="vOwnerDtlsModelCmd" id="vhclOnrReg">
			<tr>
				<td>&nbsp;First_name&nbsp;</td>
				<td><form:input path="first_name" /></td>
			</tr>
			<tr>
				<td>&nbsp;Last_name&nbsp;</td>
				<td><form:input path="last_name" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>Male<form:radiobutton path="gender" value="Male" />
					&nbsp;Female<form:radiobutton path="gender" value="Female" /></td>
			</tr>
			<tr>
				<td>&nbsp;Email&nbsp;</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>&nbsp;Ph_no&nbsp;</td>
				<td><form:input path="phno" /></td>
			</tr>
			<tr>
				<td>&nbsp;Dob&nbsp;</td>
				<td><form:input type="date" path="dob"/></td>
			</tr>
			<tr>
				<td>&nbsp;SSN&nbsp;</td>
				<td><form:input path="ssn" /></td>
			<tr>
				<td><Button type="submit">Next</Button></td>
			</tr>
		</form:form>
	</table>
</body>
</html>