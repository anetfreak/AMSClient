<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS! - Search an Employee</title>
<%@include file="includes.jsp"%>
<script type="text/javascript">
		$(document).ready(function(){
			
			$('#btnSearchEmployee').click(function(e){
				e.preventDefault();
				var firstname = $('#firstName').val();
				var lastname = $('#lastName').val();
				$.ajax({
					url : "searchEmployee.htm",
				    type: "POST",
				    data : "firstname=" + firstname + "&lastname=" + lastname,
				    success:function(data, textStatus, jqXHR){
			    		$('#body').html(data);
			    		$('#searchFlightError').css('display', 'none;');
				    },
				    error: function(jqXHR, textStatus, errorThrown){
				    	$('#searchFlightError').css('display', 'block');
				    	alert("Could not process request.. " + errorThrown);
				    }
				});
			});
		});
	</script>
</head>
<body id="body">

	<%@include file="header.jsp"%>
	<div id="container" style="margin: 0px 0px 40px 0px;">
		<div class="container-fluid">
			<div id="searchFlightError"
				class="alert alert-error alert-dismissable" style="display: none;">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					No Employees found. Please try again.....
			</div>
			<div class="row-fluid">
				<div id="searchOptions" style="margin: 30px 0px 0px 0px;">
					<div>
						<span><h3>Search Employee</h3></span>
						<h5>First Name</h5>
						<div class="input-group">
							<input type="text" id="firstName" class="required"
								placeholder="First Name">
						</div>

						<h5>Last Name</h5>
						<div class="input-group">
							<input type="text" id="lastName" class="required"
								placeholder="Last Name">
						</div>
						<div>
						<button type="submit" class="btn" id="btnSearchEmployee">Search</button>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div id="employeeSearchResult" style="margin-top: 30px;">
					<c:if test="${employees ne null}">
					<h4>Search Results</h4>
					<table class="table table-bordered table-striped" border="1">
						<tr>
							<td><B>Employee Id</B></td>
							<td><B>Hire Date</B></td>
							<td><B>Position</B></td>
							<td><B>Work Desc</B></td>
							<td><B>First Name</B></td>
							<td><B>Last Name</B></td>
							<td><B>DOB</B></td>
							<td><B>Address</B></td>
							<td><B>City</B></td>
							<td><B>State</B></td>
							<td><B>Zip Code</B></td>
							<td><B>Username</B></td>
							
						</tr>
							<c:forEach items="${employees}" var="employee">
								<tr>
									<c:if test="${employee ne null}">
										<td>${employee.employeeId}</td>
										<td>${employee.hireDate}</td>
										<td>${employee.position}</td>
										<td>${employee.workDesc}</td>
										<td>${employee.person.firstName}</td>
										<td>${employee.person.lastName}</td>
										<td>${employee.person.DOB}</td>
										<td>${employee.person.address}</td>
										<td>${employee.person.city}</td>
										<td>${employee.person.state}</td>
										<td>${employee.person.zip}</td>
										<td>${employee.person.username}</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
