<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Owner Address details</h3>
	<table>
		<form:form action="vhclOnrAddrRegdUpdt?ownerID=${ownerID}" modelAttribute="vOwnerAddrDtlsModelCmd">
			<tr>
				<td>&nbsp;H_No&nbsp;</td>
				<td><form:input path="hNo" /></td>
			</tr>
			<tr>
				<td>&nbsp;Street_Name&nbsp;</td>
				<td><form:input path="streetName" /></td>
			</tr>
			<tr>
				<td>&nbsp;City&nbsp;</td>
				<td><form:input path="city" /></td>
			</tr>			
			<tr>
				<td>&nbsp;Zip_Code&nbsp;</td>
				<td><form:input  path="zipCode" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit" >Next</button>
				<button type="reset">Reset</button>
			</tr>
		</form:form>
	</table>
</body>
</html>