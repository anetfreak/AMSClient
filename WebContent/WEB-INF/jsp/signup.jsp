<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS - Sign Up</title>

<%@include file="includes.jsp" %>

<script type="text/javascript">

$(document).ready(function () {
	
   $('#signup').click(function(event) {
	   
	   var fname = $('#firstNameInput').val();
	   var lname = $('#lastNameInput').val();
	   var email = $('#emailInput').val();
	   var password = $('#passwordInput').val();
	   var userType = $("input:radio[name=userTypeInput]:checked").val();
	   
		$.ajax({
			url : "signup.htm",
		    type: "POST",
		    data : "fname=" + fname + "&lname=" + lname + "&email=" + email + "&password=" + password + "&userType=" + userType,
		    success:function(data, textStatus, jqXHR){
		    	window.location.href="viewProjects.htm";
		    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert("Could not process request.. " + errorThrown);
		    }
		});
   });
});

</script>

</head>
<body>
	<%@include file="header.jsp" %>
	
	
	<div id="container" style="padding-top: 40px;">
		<div class="container-fluid">
			<div class="row-fluid">
				<div id="sidebar" class="span2">
						<!--Sidebar content-->
					<ul id="sidebar-list" class="nav nav-list">
					</ul>
				</div>
					<div class="tab-content">
						<div class="tab-pane active" id="NewUserSignUp">
							<table>
								<!--Body content-->
								<tr>
  									<h2>Create an AMS account here</h2>
								</tr>
								<tr>
									<td><h2 class="label label-primary">First Name</h2></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="firstNameInput" class="required" placeholder="First Name">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h2 class="label label-primary">Last Name</h2></td>
									<td></td>
									<td><div class="input-group">
											<input type="text" id="lastNameInput" class="required" placeholder="Last Name">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h2 class="label label-primary">Email</h2></td>
									<td></td>
									<td><div class="input-group">
											<input type="email" id="emailInput" class="required email" placeholder="Email ID">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h2 class="label label-primary">Password</h2></td>
									<td></td>
									<td><div class="input-group">
											<input type="password" id="passwordInput" name="passwordInput" class="required" placeholder="Password">
										</div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h2 class="label label-primary">Re-enter Password</h2></td>
									<td></td>
									<td><div class="input-group">
											<input type="password" id="reEnterPasswordInput" name="reEnterPasswordInput" class="required" placeholder="Re-enter Password" onChange="checkPasswordMatch();">
										</div></td>
									<td><div class="registrationFormAlert" id="divCheckPasswordMatch"></div></td>
								</tr>
								<tr></tr>
								<tr>
									<td><h2 class="label label-primary">You are a</h2></td>
									<td></td>
									<td><div class="col-lg-6">
   											 <div class="input-group">
      											<span class="input-group-addon">
        											<input name="userTypeInput" id="userTypeInputDeveloper" type="radio" class="required" value="0">
      											</span>
      											<h2 class="label label-primary">Project Owner</h2>
      											<span>
      												<input name="userTypeInput" id="userTypeInputTester" type="radio" class="required" value="1">
      											</span>
      											<h2 class="label label-primary">Tester</h2>
    										</div><!-- /input-group -->
  										</div><!-- /.col-lg-6 --></td>
								</tr>
								<tr></tr>
								<tr>
									<td></td>
									<td></td>
									<td><div class="col-sm-offset-2 col-sm-10">
									<input type="submit" class="btn btn-default" id="signup" value="Sign Up"/>
								</div></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	

	<%@include file="footer.jsp" %>

</body>
</html>