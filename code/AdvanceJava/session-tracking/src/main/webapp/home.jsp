<%@ page import="util.UserModel" %>
<html>
    <head>
        <title>User Home</title>
    </head>
    <body>
    <%
        UserModel model = (UserModel) session.getAttribute("userinfo");
    %>
        <h1>Welcome User <%= model.getName() %> </h1>
        <h3>Email <%= model.getEmail() %> </h3>
        <h3>City <%= model.getCity() %> </h3>
    </body>
</html>