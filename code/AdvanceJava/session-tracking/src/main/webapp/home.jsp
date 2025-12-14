<%@ page import="util.UserModel" %>
<html>
    <head>
        <title>User Home</title>
    </head>
    <body>
    <%
        UserModel model = (UserModel) session.getAttribute("userinfo");
        if(model == null || model.getName() == null) {
            System.out.println("Inside Condition");
            //response.sendRedirect("login.jsp?msg=102");
    %>
        <h2>Your Session Has been Timed out. Please <a href='login.jsp'>logging Again</a></h2>
    <%
        } else {
    %>
        <h3><a href='signout'> | Logout | </a></h3>
        <hr/>
        <h1>Welcome User <%= model.getName() %> </h1>
        <h3>Email <%= model.getEmail() %> </h3>
        <h3>City <%= model.getCity() %> </h3>

    <% } %>

    </body>
</html>