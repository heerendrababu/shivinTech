<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin</title>
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
    .admin-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    .admin-container input[type="submit"] {
        display: block;
        margin: 10px auto;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        background-color: #4CAF50;
        color: white;
    }
    .admin-container input[type="submit"]:hover {
        background-color: #45a049;
    }
    h2 {
        color: #333;
    }
</style>
</head>
<body>
   <div class="admin-container">
       <h2>Welcome Admin</h2>
       <form action="doctor" method="post">
           <input type="submit" name="getdoctorslist" value="Show Doctors List" />
           <input type="submit" name="Ddetails" value="Add Doctors Details" />
       </form>
   </div>
</body>
</html>
