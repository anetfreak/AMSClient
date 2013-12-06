<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMS - Login</title>

<%@include file="includes.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#login').click(function(event) {
			//Validate email
			if(validEmail()) {
				var email = $('#email').val();
				var password = $('#password').val();
				var userType = $("input:radio[name=userTypeInput]:checked").val();
				$.ajax({
					url : "login.htm",
				    type: "POST",
				    data : "email=" + email + "&password=" + password + "&userType=" + userType,
				    success:function(data, textStatus, jqXHR){
				    	window.location.href="/AMSClient/";
				    },
				    error: function(jqXHR, textStatus, errorThrown){
				    	alert("Could not process request.. " + errorThrown);
				    }
				});
			}
		});
		
		var validEmail = function() {
			var email = $('#email');
			var EMAIL_PATTERN = /^([a-zA-Z0-9_\-\.]+([+])?[a-zA-Z0-9_\-\.]+)@((\[[0-2]{1}[0-5]{1}[0-5]{1}\.[0-2]{1}[0-5]{1}[0-5]{1}\.[0-2]{1}[0-5]{1}[0-5]{1}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-2]{1}[0-5]{1}[0-5]{1})(\]?)$/;
			var result = false;

			// show error if field is empty or invalid email is entered
			if(email.val() == null || email.val().trim() == '') {
				alert('Please enter your email.');
			} else if(!EMAIL_PATTERN.test(email.val())) {
				alert('Email is not in a valid format.');
				email.val('');
			} else {
				result = true;
			}
			return result;
			
		};
		
	});
	
</script>

</head>
<body>
	<%@include file="header.jsp" %>

	<div id="container" style="padding-top: 40px;" align="center">
		<div class="container-fluid">
			<div id="loginOptions" style="margin: 80px 0px 0px 300px;">
				<div class="span1"></div>
				<div class="span4">
					<div style="-webkit-box-shadow: 3px 0px 5px #888888; -moz-box-shadow: 3px 0px 5px #888888; box-shadow: 3px 0px 5px #888888; padding: 30px;">
						<h3> Sign In </h3>
						<table cellpadding="5px">
							<tr>
								<td><label for="inputEmail3" class="col-sm-2 control-label">Email</label></td>
								<td><div class="col-sm-10"><input type="email" class="form-control" id="email" placeholder="Your registered email"></div></td>
							</tr>
							<tr>
								<td><label for="inputPassword3" class="col-sm-2 control-label">Password</label></td>
								<td><div class="col-sm-10"><input type="password" class="form-control" id="password" placeholder="Password"></div></td>
							</tr>
							<tr>
								<td>You are a</td>
								<td><div class="col-lg-6">
										<div class="input-group">
											<span class="input-group-addon"> 
											<input name="userTypeInput" id="userTypeInputCustomer" type="radio" class="required" value="0">
											<span style="margin-top:5px;">Customer</span>
											</span>
											<span> <input name="userTypeInput"
												id="userTypeInputEmployee" type="radio" class="required"
												value="1">
											</span>
											<span>Employee</span>
										</div>
									</div>
 								</td>
							</tr>
							<tr>
								<td></td>
								<td><div style="margin-left: 50px;"> <button type="submit" class="btn btn-success" id="login">Login</button></div></td>
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