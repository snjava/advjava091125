<html>
    <head>
        <title>personal Information</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String city = request.getParameter("city");
            String pincode = request.getParameter("pin");
            String state = request.getParameter("state");
        %>
        <h2>Step 3/3</h2>
        <hr/>
        <h2>Personal Details</h2>
          <h3>Name :  <%= name %> </h3>
          <h3>Email :  <%= email %> </h3>
          <h3>Contact :  <%= contact %> </h3>
        <h2>Address Details</h2>
          <h3>City : <%= city %> </h3>
          <h3>Pincode : <%= pincode %> </h3>
          <h3>State : <%= state %> </h3>
        <a href='save-data?company=XYZ&name=<%=name%>&email=<%=email%>&contact=<%=contact%>&city=<%=city%>&pin=<%=pincode%>&state=<%=state%>'>Save</a>
    </body>
</html>






