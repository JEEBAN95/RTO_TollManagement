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
					<a href="home"><button type="button" style="background-color: #00BFFF; color: white;">Home</button></a>
				</h2>
			<td>
			<td><h2>
					<a href="vhclRegUpdate?ownerID=${ownerID}"><button
							type="button" style="background-color: #FF7F50">Previous</button></a>
				</h2></td>
		<tr>
	</table>
	<br>
	<br>
	<table style="width: 100%; height: 100%;">
		<tr>
			<td>
				<div>
					<table>
						<c:if test="${!empty vhclDtls}">
							<tr>
								<td>&nbsp;Vehicle Type&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.vtype}</label></td>
							</tr>
							<tr>
								<td>&nbsp;MFG Year&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.mfgYear}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Brand Name&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.brandName}</label></td>
							</tr>
						</c:if>
					</table>
				</div>
			</td>
			<td>
				<div >
					<table>
						<c:if test="${!empty vhclDtls}">
							<tr>
								<td>&nbsp;First Name&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.first_name}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Last Name&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.last_name}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Gender&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.gender}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Date of Birth&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.dob}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Email&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.email}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Phone no&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.phno}</label></td>
							</tr>
							<tr>
								<td>&nbsp;SSN&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.ssn}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Created Date&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.createdDate}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Update Date&nbsp;</td>
								<td><label>:&nbsp;${vhclDtls.owner.updateDate}</label></td>
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
								<td>&nbsp;House no&nbsp;</td>
								<td><label>:&nbsp;${vhclOnrAddrDtls.HNo}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Street Name&nbsp;</td>
								<td><label>:&nbsp;${vhclOnrAddrDtls.streetName}</label></td>
							</tr>
							<tr>
								<td>&nbsp;City&nbsp;</td>
								<td><label>:&nbsp;${vhclOnrAddrDtls.city}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Zip. Code&nbsp;</td>
								<td><label>:&nbsp;${vhclOnrAddrDtls.zipCode}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Created Date&nbsp;</td>
								<td><label>:&nbsp;${vhclOnrAddrDtls.createdDate}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Update Date&nbsp;</td>
								<td><label>:&nbsp;${vhclOnrAddrDtls.updateDate}</label></td>
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
								<td>&nbsp;Regd. Date&nbsp;</td>
								<td><label>:&nbsp;${vhclRegdDtls.regdDate}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Regd. Center&nbsp;</td>
								<td><label>:&nbsp;${vhclRegdDtls.regCenter}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Created Date&nbsp;</td>
								<td><label>:&nbsp;${vhclRegdDtls.createdDate}</label></td>
							</tr>
							<tr>
								<td>&nbsp;Update Date&nbsp;</td>
								<td><label>:&nbsp;${vhclRegdDtls.updateDate}</label></td>
							</tr>
						</c:if>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<br>
	<h3>Click on register to get vehicle registration number.</h3>
	<a href="showDetails?vRId=${vhclRegdDtls.regdId}"><button
			type="button" style="background-color:lime;">Register</button></a>
	<br>
	<h3>
		<b style="color: blue;">${success}&nbsp;</b>
	</h3>
	<h3>
		<b>Vehicle Registration Number is&nbsp;:<label style="color: red;">&nbsp;${vhclRegdNum}</label></b>
	</h3>

</body>
</html>