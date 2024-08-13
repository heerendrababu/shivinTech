<%@ page import="com.shivintech.model.Doctor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Doctor Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            max-width: 800px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        .form-container h1 {
            text-align: center;
        }
        .form-container table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .form-container table, th, td {
            border: 1px solid black;
        }
        .form-container th, td {
            padding: 10px;
            text-align: left;
        }
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            margin-top: 20px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Doctors Details</h1>
    <form action="BookedPatient.jsp" method="post">
        <label for="appointmentDate">Select Date:</label>
        <input type="date" id="appointmentDate" name="appointmentDate" required /><br><br>
        <table>
            <tr>
                <th>Name</th>
                <th>Profession</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Action</th>
            </tr>
            <% 
            ArrayList<Doctor> al = (ArrayList<Doctor>) request.getAttribute("doctorlist");
            if (al != null && !al.isEmpty()) {
                for (Doctor d : al) {
            %>
                <tr>
                    <td><%= d.getName() %></td>
                    <td><%= d.getProfession() %></td>
                    <td><%= d.getEmail() %></td>
                    <td><%= d.getMobile() %></td>
                    <td>
                        <input type="radio" name="doctorId" value="<%= d.getDid() %>" required />
                        <input type="hidden" name="doctorName_<%= d.getDid() %>" value="<%= d.getName() %>" />
                        <input type="hidden" name="doctorProfession_<%= d.getDid() %>" value="<%= d.getProfession() %>" />
                        <input type="hidden" name="doctorEmail_<%= d.getDid() %>" value="<%= d.getEmail() %>"/>
                        <input type="hidden" name="doctorMobile_<%= d.getDid() %>" value="<%= d.getMobile() %>" />
                    </td>
                </tr>
            <% 
                }
            } else {
            %>
                <tr>
                    <td colspan="5">No doctors available</td>
                </tr>
            <% 
            }
            %>
        </table>
        <input type="submit" value="Book Doctor">
    </form>
</div>
</body>
</html>
