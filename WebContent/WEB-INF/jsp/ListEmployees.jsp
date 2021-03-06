<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - List Employees</title>
<%@include file="includes.jsp" %>

</head>
<body>
	<%@include file="header.jsp" %>
	<div id="container" style="padding-top: 40px;" align="center">
		<table class="table table-bordered table-striped" border="1">
			<tr>
				<td><B>First Name</B></td>
				<td><B>Last Name</B></td>
				<td><B>Address</B></td>
				<td><B>City</B></td>
				<td><B>State</B></td>
				<td><B>Zip Code</B></td>
				<td><B>User Name</B></td>
				<td><B>Hire Date</B></td>
				<td><B>Position</B></td>
				<td><B>Work Desc</B></td>
				<td><B>SSN</B></td>
				<td><B>DOB</B></td>
			</tr>
			<c:if test="${Employees ne null}">
				<c:forEach items="${Employees}" var="employee">
					<tr>
						<c:if test="${employee ne null}">
							<td>${employee.person.firstName}</td>
							<td>${employee.person.lastName}</td>
							<td>${employee.person.address}</td>
							<td>${employee.person.city}</td>
							<td>${employee.person.state}</td>
							<td>${employee.person.zip}</td>
							<td>${employee.person.username}</td>
							<td>${employee.hireDate}</td>
							<td>${employee.position}</td>
							<td>${employee.workDesc}</td>
							<td>${employee.employeeId}</td>
							<td>${employee.person.DOB}</td>
							<td><div class="col-sm-offset-2 col-sm-10">
									<a href="/AMSClient/deleteEmployee/${employee.employeeId}.htm" class="btn btn-default" 
									id="deleteEmployee" name="deleteEmployee">Delete Employee</a>
								</div></td>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>
