<div id="header">
	<div class="navbar navbar-static-top">
		<div id="headerNav" class="navbar-inner">
			<a class="brand" href="/AMSClient/"><span style="margin: 0px 10px 0px 10px;">AMS</span></a>
			<% if(session.getAttribute("sessionId") != null) { %>
			<ul id="testMenu" class="nav">
				<li><a href="/AMSClient/searchFlight.htm">Search Flight</a></li>
				<li><a href="/AMSClient/ShowReservation.htm">Show Reservation</a></li>
				<% if(session.getAttribute("isAdmin") != null) { %>
					<li><a href="/AMSClient/ListFlight.htm">List Flights</a></li>
					<li><a href="/AMSClient/ListEmployees.htm">List Employees</a></li>
					<li><a href="/AMSClient/ListReservations.htm">List Reservations</a></li>
					<li><a href="/AMSClient/ListCustomers.htm">List Customers</a></li>
					<li><a href="/AMSClient/searchEmployee.htm">Search Employee</a>
				<% } %>
			</ul>
			<% } %>
			<% if(session.getAttribute("sessionId") == null) { %>
			<ul id="loginMenu" class="nav" style=" float:right;">
				<li><a href="/AMSClient/login.htm">Login</a></li>
				<li><a href="/AMSClient/signup.htm">Sign Up</a></li>
			</ul>
			<% } else { %>
			<ul id="loggedInMenu" class="nav" style=" float:right; padding-right: 35px;">
				<li class="dropdown" id="loggedInDown">
					<% if(session.getAttribute("isAdmin") == null) { %>
	 					<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown">Hello ${firstname} <span class="caret"></span></a>
	 				<% } else { %>
	 					<a class="dropdown-toggle" data-toggle="dropdown" href="#loggedInDown">Hello Admin <span class="caret"></span></a>
	 				<% } %>
					<ul class="dropdown-menu">
					<% if(session.getAttribute("isAdmin") == null) { %>
				      <li><a href="/AMSClient/ViewProfile.htm">Profile</a></li>
				    <% } %>
				      <li><a href="/AMSClient/logout.htm">Logout</a></li>
				    </ul>
			    </li>
			</ul>
			<% } %>
		</div>
	</div>
</div>
