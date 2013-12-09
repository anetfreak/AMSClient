<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AMS - Payment</title>

<%@include file="includes.jsp" %>
<script type = "text/javascript">

$(document).ready(function(){
	
	var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

    var expiry = $('#expireDate').datepicker({
      onRender: function(date) {
        return date.valueOf() < now.valueOf() ? 'disabled' : '';
      }
    }).data('datepicker');
    
    function validateForm() {
		var name = document.forms["paymentform"]["ownerName"].value;
		var cardNumber1 = document.forms["paymentform"]["cardNumber1"].value;
		var cardNumber2 = document.forms["paymentform"]["cardNumber2"].value;
		var cardNumber3 = document.forms["paymentform"]["cardNumber3"].value;
		var cardNumber4 = document.forms["paymentform"]["cardNumber4"].value;
		var cvv = document.forms["paymentform"]["cvv"].value;
		//var expiryDate = document.forms["paymentform"]["expiryDate"].value;
		var expiryDate = $('#expireDate').val();
		
		var letters = /^[A-Za-z]+$/;
		var numbers = /^[0-9]+$/;
		
		if((name == null) || (name == "") || (cardNumber1 == null) || (cardNumber1 == "") || (cardNumber2 == null)
				|| (cardNumber2 == "") || (cardNumber3 == null) || (cardNumber3 == "") || (cardNumber4 == null) ||
					(cardNumber4 == "") || (cvv == null) || (cvv == "") || (expiryDate == null) || (expiryDate == "")){
			alert("All fields should be filled!");
			return false;
		}
		if(!name.match(letters)) {
			alert("Not a valid name!");
			return false;
		}
		if((!cardNumber1.match(numbers)) || (!cardNumber2.match(numbers)) || (!cardNumber3.match(numbers)) || (!cardNumber4.match(numbers))) {
			alert("Not a valid credit card number!");
			return false;
		}
		if(!cvv.match(numbers)) {
			alert("Not a valid cvv number!");
			return false;
		}
	}
    
    $('#payment').click(function(){
    	if(validateForm){
    	var name = $('#ownerName').val();
		var cardNumber1 = $('#cardNumber1').val();
		var cardNumber2 = $('#cardNumber2').val();
		var cardNumber3 = $('#cardNumber3').val();
		var cardNumber4 = $('#cardNumber4').val();
		var cvv = $('#cvv').val();
		var card = cardNumber1 + cardNumber2 + cardNumber3 + cardNumber4;
		var expiryDate = $('#expireDate').val();
		
    	$.ajax({
			url : "issueTicket.htm",
		    type: "POST",
		    data : "name=" + name + "&card=" + card + "&cvv=" + cvv + "&expiryDate=" + expiryDate,
		    success:function(data, textStatus, jqXHR){
		    	window.location.href = "issueTicket.htm";
		    },
		    error: function(jqXHR, textStatus, errorThrown){
			    	alert("Could not process request.. " + errorThrown);
		    }
		});
    }
    });
});
</script>
</head>
<body>
<%@include file="header.jsp" %>
	<div style = "padding: 30px;">
		<div>
			<span><h3>Payment Option</h3></span>
		</div>
		<div>
			<table>
				<tr>
					<td>Name on Credit Card : </td>
					<td><input type = "text" id = "ownerName" name = "ownerName" style = "width: 230px;"></td>
				</tr>
				<tr>
					<td>Card Number : </td>
					<td><input type = "text" id = "cardNumber1" name = "cardNumber1" maxlength = "4" style = "width: 40px;">-
					<input type = "text" id = "cardNumber2" name = "cardNumber2" maxlength = "4" style = "width: 40px;">-
					<input type = "text" id = "cardNumber3" name = "cardNumber3" maxlength = "4" style = "width: 40px;">-
					<input type = "text" id = "cardNumber4" name = "cardNumber4" maxlength = "4" style = "width: 40px;"></td>
				</tr>
				<tr>
					<td>CVV Number : </td>
					<td><input type = "text" id = "cvv" name = "cvv" maxlength = "3" style = "width: 30px;"></td>
				</tr>
				<tr>
					<td>Expiry Date : </td>
					<td><input id="expireDate" size="16" type="text" readonly data-date-minviewmode="months" data-date-format="yyyy-mm-dd" placeholder="Your Card's Expiry Date" style = "width: 230px;">
				</tr>
				<tr>
					<td></td>
					<td><input class="btn btn-primary" type = "submit" name = "payment" id = "payment" value = "Pay Now"></td>
				</tr>
			</table>
		</div>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>