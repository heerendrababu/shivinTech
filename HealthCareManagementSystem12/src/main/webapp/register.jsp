<%@page import="com.shivintech.model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Registration Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f2f2f2;
    }
    .registration-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    table {
        margin: 0 auto;
    }
    td {
        padding: 10px;
    }
    input[type="text"], input[type="email"], input[type="password"], input[type="tel"], input[type="number"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    .result-message {
        text-align: center;
        color: red;
        margin-top: 10px;
    }
</style>
</head>
<body>
   <%
   Doctor d = (Doctor)request.getAttribute("doctor");
    if(d == null)
    {
   %>
   <div class="registration-container">
      <h2>Doctor Registration</h2>
       <form action="reg" method = "post">
           <table>
               <tr hidden>
                   <td colspan="2"><input type="number" name="dId" /></td>
               </tr>
               <tr>
                   <td>Name:</td>
                   <td><input type="text" name="dName" /></td>
               </tr>
               <tr>
                   <td>Email:</td>
                   <td><input type="email" name="dEmail" /></td>
               </tr>
               <tr>
                   <td>Profession:</td>
                   <td><input type="text" name="dProfess" required /></td>
               </tr>
               <tr>
                   <td>Password:</td>
                   <td><input type="password" name="dPass" required /></td>
               </tr>
               <tr>
                   <td>Mobile:</td>
                   <td><input type="tel" name="dMobile" /></td>
               </tr>
               <tr>
                   <td colspan="2" style="text-align: center;">
                       <input type="submit" name="btnReg" value="Click Here" />
                   </td>
               </tr>
           </table>
           <div class="result-message">
               <%
                   String result = (String) request.getAttribute("res");
                   if (result != null) {
                       out.print(result);
                   }
               %>
           </div>
       </form>
   </div>
   <%
   } else {
   %>
   <div class="registration-container">
      <h2>Doctor Edit Form</h2>
      <form action="update" method = "post">
          <table>
              <tr hidden>
                  <td colspan="2"><input type="number" name="dId" value="<%=d.getDid()%>" /></td>
              </tr>  <!-- value attribute is used get old value into form control for editing purpose-->
              <tr>
                  <td>Name:</td>
                  <td><input type="text" name="dName" value="<%=d.getName()%>" /></td>
              </tr>
              <tr>
                  <td>Email:</td>
                  <td><input type="email" name="dEmail" value="<%=d.getEmail()%>" /></td>
              </tr>
              <tr>
                  <td>Profession:</td>
                  <td><input type="text" name="dProfess" required value="<%=d.getProfession()%>" /></td>
              </tr>
              <tr>
                  <td>Password:</td>
                  <td><input type="password" name="dPass" required value="<%=d.getPassword()%>" /></td>
              </tr>
              <tr>
                  <td>Mobile:</td>
                  <td><input type="tel" name="dMobile" value="<%=d.getMobile()%>" /></td>
              </tr>
              <tr>
                  <td colspan="2" style="text-align: center;">
                      <input type="submit" name="btnReg" value="Update" />
                  </td>
              </tr>
          </table>
          <div class="result-message">
              <%
                  String result = (String) request.getAttribute("res");
                  if (result != null) {
                      out.print(result);
                  }
              %>
          </div>
      </form>
   </div>
   <%
   }
   %>
</body>
</html>
