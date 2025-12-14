<html>
    <head>
        <title>User Login</title>
    </head>
    <body>
        <h2>User Login</h2>

        <%
            String message = request.getParameter("msg");
            String displayMessage = "";
            String color = "";
            if(message!=null) {
                switch(message) {
                    case "100":
                        displayMessage = "Invalid User name or password";
                        color = "red";
                        break;
                   case "101":
                       displayMessage = "You Have been successfully logged out";
                       color = "green";
                       break;
                   case "102":
                      displayMessage = "Your Session Has been Timed out. Please logging Again";
                      color = "yellow";
                      break;
                }
            }
        %>

        <%
            if(message!=null) {
       %>
            <h3 style='color:<%=color%>'> <%=displayMessage%> </h3>
       <%
            }
        %>

        <form action='auth-user'>
            Enter User Name : <input type='text' name='uname'>
            <br/><br/>
            Enter Password : <input type='password' name='upass'>
            <br/><br/>
            <button type='submit'>Login</button>
        </form>
    </body>
</html>