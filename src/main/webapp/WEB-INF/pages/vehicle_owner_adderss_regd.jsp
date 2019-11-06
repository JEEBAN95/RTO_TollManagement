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
	<h3>Owner Address details</h3>
	<table>
		<form:form action="vhclOnrAddrRegd?ownerID=${ownerID}"
			modelAttribute="vOwnerAddrDtlsModelCmd">
			<tr>
				<td>&nbsp;House No&nbsp;</td>
				<td><form:input path="hNo" /></td>
			</tr>
			<tr>
				<td>&nbsp;Street Name&nbsp;</td>
				<td><form:input path="streetName" /></td>
			</tr>
			<tr>
				<td>&nbsp;City&nbsp;</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>&nbsp;Zip Code&nbsp;</td>
				<td><form:input path="zipCode" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<Button type="submit"
						style="background-color: #00BFFF; color: white;">Next</Button> <a
					href="updateVhclOnr?ownerID=${ownerID}"><button type="button"
							style="background-color: #FF7F50">Previous</button></a>
					<button type="reset"
						style="background-color: #FF4500; color: white;">Reset</button>
			</tr>
		</form:form>
	</table>
</body>
</html>