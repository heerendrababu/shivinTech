<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.shivintech.model.Patient" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Doctor</title>
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
    .container {
        text-align: center;
    }
    .container form {
        margin-top: 20px;
    }
    table {
        width: 80%;
        margin: 20px auto; /* Center-align the table */
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
    /* Button styles */
    .get-details-button {
        background-color: #4CAF50; /* Green */
        color: white;
        border: none;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin-top: 10px;
        cursor: pointer;
        border-radius: 5px;
    }
    .send-report-button {
        background-color: #008CBA; /* Blue */
        color: white;
        border: none;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin-top: 10px;
        cursor: pointer;
        border-radius: 5px;
    }
</style>
<script>
    function hideForm() {
        document.getElementById('doctorForm').style.display = 'none';
    }

    function showReportForm() {
        document.getElementById('reportForm').style.display = 'block';
        document.getElementById('doctorForm').style.display = 'none';
    }
</script>
</head>
<body onload="<% if (request.getAttribute("patientlist") != null) { %> hideForm(); <% } %>">
<div class="container">
    <div id="doctorForm">
        <form action="dlogin" method="post">
            <h2>Welcome Doctor</h2>
            <input type="submit" name="GetPatientDetails" value="Get Patient Details" class="get-details-button" /><br><br>
            <input type="button" name="sendReport" value="Send Report" onclick="showReportForm();" class="send-report-button" />
        </form>
    </div>

    <%-- Check if patientList exists and is not empty --%>
    <% if (request.getAttribute("patientlist") != null) { %>
        <table>
            <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <!-- Add more headers as needed -->
                </tr>
            </thead>
            <tbody>
                <% ArrayList<Patient> patientList = (ArrayList<Patient>) request.getAttribute("patientlist"); %>
                <% for (Patient p : patientList) { %>
                    <tr>
                        <td><%=p.getPid() %></td>
                        <td><%=p.getName() %></td>
                        <td><%=p.getEmail() %></td>
                        <td><%=p.getGender() %></td>
                        <!-- Add more columns as needed -->
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>

    <div id="reportForm" style="display: none;">
        <form action="sendReportAction" method="post">
            <h2>Send Report</h2>
            <textarea name="reportText" rows="4" cols="50" placeholder="Enter report text here..."></textarea><br><br>
            <input type="submit" name = "sendReport "value="Send Report" class="send-report-button">
            <%-- Display success message if report sent successfully --%>
            <% if (request.getAttribute("reportSent") != null && (boolean) request.getAttribute("reportSent")) { %>
                <div style="color: green;">Report sent successfully!</div>
            <% } %>
        </form>
    </div>
</div>

</body>
</html>
