<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td><h2>
					<a href="home"><button type="button">Home</button></a>
				</h2>
			<td>
			<td><h2>
					<a href="vhclRegUpdate?ownerID=${ownerID}"><button
							type="button">Previous</button></a>
				</h2></td>
		<tr>
	</table>
	<br>
	<br>
	<table style="width: 100%; height: 100%">
		<tr>
			<td>
				<div>
					<table>
						<c:if test="${!empty vhclDtls}">
							<tr>
								<td>&nbsp;Vehicle Type&nbsp;</td>
								<td><input type="text" value="${vhclDtls.vtype}" disabled></td>
							</tr>
							<tr>
								<td>&nbsp;mfgYear&nbsp;</td>
								<td><input type="text" value="${vhclDtls.mfgYear}" disabled></td>
							</tr>
							<tr>
								<td>&nbsp;brandName&nbsp;</td>
								<td><input type="text" value="${vhclDtls.brandName}"
									disabled></td>
							</tr>
						</c:if>
					</table>
					<br> <br>
				</div>
			</td>

			<td>
				<div>
					<table>
						<c:if test="${!empty vhclDtls}">
							<tr>
								<td>&nbsp;first_name&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.first_name}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;last_name&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.last_name}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;gender&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.gender}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;dob&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.dob}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;email&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.email}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;phno&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.phno}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;ssn&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.ssn}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;createdDate&nbsp;</td>
								<td><input type="text"
									value="${vhclDtls.owner.createdDate}" disabled></td>
							</tr>
							<tr>
								<td>&nbsp;updateDate&nbsp;</td>
								<td><input type="text" value="${vhclDtls.owner.updateDate}"
									disabled></td>
							</tr>

						</c:if>
					</table>
				</div>
			</td>

			<td>
				<div>
					<table>
						<c:if test="${!empty vhclOnrAddrDtls}">
							<tr>
								<td>&nbsp;hno&nbsp;</td>
								<td><input type="text" value="${vhclOnrAddrDtls.HNo}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;streetName&nbsp;</td>
								<td><input type="text"
									value="${vhclOnrAddrDtls.streetName}" disabled></td>
							</tr>
							<tr>
								<td>&nbsp;city&nbsp;</td>
								<td><input type="text" value="${vhclOnrAddrDtls.city}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;zipCode&nbsp;</td>
								<td><input type="text" value="${vhclOnrAddrDtls.zipCode}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;createdDate&nbsp;</td>
								<td><input type="text"
									value="${vhclOnrAddrDtls.createdDate}" disabled></td>
							</tr>
							<tr>
								<td>&nbsp;updateDate&nbsp;</td>
								<td><input type="text"
									value="${vhclOnrAddrDtls.updateDate}" disabled></td>
							</tr>
						</c:if>
					</table>
				</div>
			</td>
			<td>
				<div>
					<table>
						<c:if test="${!empty vhclRegdDtls}">
							<tr>
								<td>&nbsp;regdDate&nbsp;</td>
								<td><input type="text" value="${vhclRegdDtls.regdDate}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;regCenter&nbsp;</td>
								<td><input type="text" value="${vhclRegdDtls.regCenter}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;createdDate&nbsp;</td>
								<td><input type="text" value="${vhclRegdDtls.createdDate}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;updateDate&nbsp;</td>
								<td><input type="text" value="${vhclRegdDtls.updateDate}"
									disabled></td>
							</tr>
							<tr>
								<td>&nbsp;vehiceRegdNum&nbsp;</td>
								<td><input type="text"
									value="${vhclRegdDtls.vehiceRegdNum}" disabled></td>
							</tr>
						</c:if>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<h3>Get all Vehicle-Owner Information</h3>
	<a href="showDetails"><button type="button" >Show Details</button></a>
</body>
</html>