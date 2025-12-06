<html>
    <head>
        <title>Display Information</title>
    </head>
    <body>
        <h1>Welcome User, </h1>
        <%
            String fn = request.getParameter("fname");
            String ln = request.getParameter("lname");
            String gender = request.getParameter("gender");
            String fullName = fn + " " + ln;
            String prefix = "M".equals(gender) ? "Mr. " : "Ms. ";
        %>
        <h2> <%= prefix + fullName  %>  </h2>
    </body>
</html>