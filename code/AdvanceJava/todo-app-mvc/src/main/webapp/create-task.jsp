<html>
<head>
    <title>TODO App - Create Task</title>
</head>
<body>
<%@ include file='navigation.jsp'%>

<center>
    <h2>Create New Task</h2>
    <form action=''>
        Enter Task Title: <input type='text' name = 'title' placeholder='Enter Title'>
        <br/><br/>
        Enter Task Description: <textarea rows='3' cols='15' name='desc'></textarea>
        <br/><br/>
        Select Status: <select name='status'>
                            <option>Open</option>
                            <option>Inprogress</option>
                            <option>Completed</option>
                        </select>
        <br/><br/>
        Select Task Date: <input type='date' name='taskDate'>
        <br/><br/>
        <button type='submit'>Create Task</button>
    </form>
</center>

</body>
</html>
