<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>

<style>
div
{
   	margin-left: 650px;
}
</style>

</head>
<body>
<div>
 <!--  <%=request.getAttribute("appointmentSuccess") %> -->
  <% String message = (String) request.getAttribute("message"); %>

<form action = "Patient.jsp">
   <H2>Success</H2>
<input type ="submit" value="BackToLoginPage"/>

</form>
</div>

</body>
</html>