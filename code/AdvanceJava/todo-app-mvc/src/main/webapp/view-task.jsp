<%@ page import="java.util.*"%>
<%@ page import="com.dto.*"%>
<html>
<head>
    <title>TODO App - Home</title>
</head>
<body>
<%@ include file='navigation.jsp'%>
<center>
<h2>My TasK List</h2>

<table border='1'>
<tr>
    <th>Title</th>
    <th>Description</th>
    <th>Status</th>
    <th>Scheduled Date</th>
    <th>Action</th>
</tr>
<%
    List<TaskDto> list = (List<TaskDto>) request.getAttribute("mytask");
    for(TaskDto task : list) {
%>
<tr>
    <td><%=task.getTitle()%></td>
    <td><%=task.getTaskDesc()%></td>
    <td><%=task.getStatus()%></td>
    <td><%=task.getScheduledDt()%></td>
    <td><a href='#'>Edit</a> / <a href='#'>Delete</a></td>
</tr>
<% } %>
</table>

</center>
</body>
</html>
