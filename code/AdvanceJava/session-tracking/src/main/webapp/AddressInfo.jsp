<html>
    <head>
        <title>personal Information</title>
    </head>
    <body>
        <h2>Step 2/3</h2>
        <hr/>
        <h2>Address Details</h2>
        <form action='Preview.jsp'>
        <input type='hidden' name='name' value='<%=request.getParameter("name")%>'>
        <input type='hidden' name='email' value='<%=request.getParameter("email")%>'>
        <input type='hidden' name='contact' value='<%=request.getParameter("contact")%>'>
        Enter City : <input type='text' name='city'>
        <br/><br/>
        Enter Pincode : <input type='text' name='pin'>
        <br/><br/>
        Enter State : <input type='text' name='state'>
        <br/><br/>
        <button type='submit'>Next</button>
        </form>
    </body>
</html>