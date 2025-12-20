<html>
<head>
    <title>TODO App - Create Task</title>
</head>
<body>
<%@ include file='navigation.jsp'%>
<center>
    <h2>Create New Task</h2>
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
