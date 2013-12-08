<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
	<div class="navbar navbar-static-top">
		<div id="headerNav" class="navbar-inner">
			<a class="brand" href="/AMSClient/"><span style="margin: 0px 10px 0px 10px;">AMS</span></a>
			<ul id="testMenu" class="nav">
				<li><a href="ListFlight.htm">List Flights</a></li>
				<li><a href="searchFlight.htm">Search Flight</a></li>
				<li><a href="ListEmployees.htm">List Employees</a></li>
				<li><a href="ListReservations.htm">List Reservations</a></li>
				<li><a href="ListCustomers.htm">List Customers</a></li>
			</ul>
			<% if(session.getAttribute("sessionId") == null) { %>
			<ul id="loginMenu" class="nav" style=" float:right;">
				<li><a href="login.htm">Login</a></li>
				<li><a href="signup.htm">Sign Up</a></li>
			</ul>
			<% } else { %>
			<ul id="loggedInMenu" class="nav" style=" float:right; padding-right: 35px;">
				<li class="dropdown" id="loggedInDown">
	 				<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown">Hello ${firstname} <span class="caret"></span></a>
					<ul class="dropdown-menu">
				      <li><a href="ViewProfile.htm">Profile</a></li>
				      <li><a href="logout.htm">Logout</a></li>
				    </ul>
			    </li>
			</ul>
			<% } %>
		</div>
	</div>
</div>
