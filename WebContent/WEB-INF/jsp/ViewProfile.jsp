<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS - Edit Profile</title>

<%@include file="includes.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
						$('#viewProfile').click(function(event) {
												var fname = $('#firstName').val();
												var lname = $('#lastName').val();
												var email = $('#email').val();
												var password = $('#password').val();
												var address = $('#address').val();
												var city = $('#city').val();
												var state = $('#state').val();
												var pincode = $('#zipCode').val();
												var dob = $('#dob').val();
												var passport = $('#passport').val();
												var nationality = $('#nationality').val();
												var workdesc = $('#workDesc').val();
												var position = $('#position').val();
												var hiredate = $('#hireDate').val();
												var ssn = $('#ssn').val();
												var userType = $("input:radio[name=userTypeInput]:checked").val();
												$.ajax({
															url : "EditProfile.htm",
															type : "POST",
															data : "email="
																	+ email
																	+ "&password="
																	+ password
																	+ "&userType="
																	+ userType
																	+ "&fname="
																	+ fname
																	+ "&lname="
																	+ lname
																	+ "&address="
																	+ address
																	+ "&city="
																	+ city
																	+ "&state="
																	+ state
																	+ "&pincode="
																	+ pincode
																	+ "&dob="
																	+ dob
																	+ "&passport="
																	+ passport
																	+ "&nationality="
																	+ nationality
																	+ "&workdesc="
																	+ workdesc
																	+ "&position="
																	+ position
																	+ "&hiredate="
																	+ hiredate
																	+ "&ssn="
																	+ ssn
																	+ "&isUpdate=true",
															success : function(
																	data,
																	textStatus,
																	jqXHR) {
																if(data.response == "success") {
														    		window.location.href="EditProfile.htm";
														    	} 
																},
															error : function(
																	jqXHR,
																	textStatus,
																	errorThrown) {
																$('#loginError').css('display','none');
															}
														});
											
										});
					});
</script>

</head>
<body>
	<%@include file="header.jsp"%>


	<div id="container" style="padding: 40px 0px 80px 0px;">
		<div class="container-fluid">
			<div class="row-fluid">
				<div id="sidebar" class="span2">
					<!--Sidebar content-->
					<ul id="sidebar-list" class="nav nav-list">
					</ul>
				</div>
				<div class="tab-content">
					<div class="tab-pane active" id="ViewUserProfile">
						<table>
							<!--Body content-->
							<tr>
								<td><h2>${person.firstName}'s Profile</h2></td>
							</tr>
							<tr>
								<c:choose>
									<c:when test="${person.personType eq 1}">
									<td><h5>You are an</h5></td>
										<td>Employee</td>
									</c:when>
									<c:otherwise>
									<td><h5>You are a </h5></td>
										<td>Customer</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td><h5>First Name</h5></td>
								<td>${person.firstName}</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Last Name</h5></td>
								<td>${person.lastName}</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Email</h5></td>
								<td>${person.username}</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Social Security Number</h5></td>
								<td><div class="input-group">
										<c:choose>
											<c:when test="${person.personType eq 1}">
												${employee.employeeId}
											</c:when>
											<c:otherwise>
												${customer.customerId}
											</c:otherwise>
										</c:choose>
									</div></td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Address</h5></td>
								<td>${person.address}
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>City</h5></td>
								<td>${person.city}
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>State</h5></td>
								<td>${person.state}
									</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>PinCode</h5></td>
								<td>${person.zip}
								</td>
							</tr>
							<tr></tr>
							<tr>
								<td><h5>Date Of Birth</h5></td>
								<td>${person.DOB}</td>
							</tr>
							
							<!-- Extra Fields -->
							<c:choose>
								<c:when test="${person.personType eq 2}">
									<tr class="customerExtra"></tr>
									<tr class="customerExtra">
										<td><h5>Passport Number</h5></td>
										<td>${customer.passportNumber}</td>
									</tr>
									<tr class="customerExtra"></tr>
									<tr class="customerExtra">
										<td><h5>Nationality</h5></td>
										<td>${customer.nationality}</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="empExtra"></tr>
									<tr class="empExtra">
										<td><h5>Work Description</h5></td>
										<td>${employee.workDesc}</td>
									</tr>
									<tr class="empExtra"></tr>
									<tr class="empExtra">
										<td><h5>Position</h5></td>
										<td>${employee.position}</td>
									</tr>
									<tr class="empExtra"></tr>
									<tr class="empExtra">
										<td><h5>Hire Date</h5></td>
										<td>${employee.hireDate}</td>
									</tr>
								</c:otherwise>
							</c:choose>
							<!-- End Extra -->
							<tr></tr>
							<tr>
								<td></td>
								<td><div class="col-sm-offset-2 col-sm-10">
										<input type="submit" class="btn btn-default"
											id="viewProfile" value="Edit Profile" />
									</div></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>