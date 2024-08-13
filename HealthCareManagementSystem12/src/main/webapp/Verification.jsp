<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div
{
   	margin-left: 650px;
}
</style>
</head>
<body>
<div>
  <% String message = (String) request.getAttribute("me"); %>
    <% if (message != null) { %>
        <p style="color: green; text-align: center;"><%= message %></p>
    <% } %>
 <form action = "backtologin" method = "post">

 <input type = "submit" name = "back" value = "Back to Login Page"/>
 <br>
 
 <%=request.getAttribute("check") %>


</form>

</div>
</body>
</html>