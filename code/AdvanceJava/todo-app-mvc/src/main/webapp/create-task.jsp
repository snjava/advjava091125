<html>
<head>
    <title>TODO App - Create Task</title>
</head>
<body>
<%@ include file='navigation.jsp'%>
<%
    String code = request.getParameter("code");
    String msg= "";
    String color="";
    if("1".equals(code)) {
        msg = "Your Task Created Successfully...";
        color="green";
    } else if("2".equals(code)){
        msg = "Your Task Creation Failed. Try after Some time...!";
        color="red";
    }
%>
<center>
    <h2>Create New Task</h2>
    <% if(code != null) { %>
        <h3 style='color:<%=color%>'><%=msg%><h3>
    <%}%>
    <form action='create-my-task'>
        Enter Task Title: <input type='text' name = 'title' placeholder='Enter Title'>
        <br/><br/>
        Enter Task Description: <textarea rows='3' cols='15' name='desc'></textarea>
        <br/><br/>
        Select Status: <select name='status'>
                            <option value='open'>Open</option>
                            <option value='inprogress'>Inprogress</option>
                            <option value='completed'>Completed</option>
                        </select>
        <br/><br/>
        Select Task Date: <input type='date' name='taskDate'>
        <br/><br/>
        <button type='submit'>Create Task</button>
    </form>
</center>

</body>
</html>
