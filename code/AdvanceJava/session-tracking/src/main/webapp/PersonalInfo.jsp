<html>
    <head>
        <title>personal Information</title>
    </head>
    <body>
        <h2>Step 1/3</h2>
        <hr/>
        <%
            String msg = request.getParameter("msg");
         %>
        <%
            if(msg != null && "error".equals(msg)) {
        %>
            <h3 style='color:red'>Unable To Save the User Details</h3>
         <%
            }
         %>
         <%
             if(msg != null && "success".equals(msg)) {
         %>
         <h3 style='color:green'>User Details Save Successfully..</h3>
         <%
             }
          %>
        <h2>Personal Details</h2>
        <form action='AddressInfo.jsp'>
            Enter Name : <input type='text' name='name'>
            <br/><br/>
            Enter Email : <input type='text' name='email'>
            <br/><br/>
            Enter Contact : <input type='text' name='contact'>
            <br/><br/>
            <button type='submit'>Next</button>
        </form>
    </body>
</html>