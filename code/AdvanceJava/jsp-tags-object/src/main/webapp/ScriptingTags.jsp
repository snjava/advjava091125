<html>
    <head>
        <title>Display User Information</title>
    </head>
    <body>
        <h1>Scripting Tags</h1>
        <%
            int a = 10;
            System.out.println("THIS IS FROM JSP PAGE");
        %>

        Square : <%= a * a %>
           </br>
        <%
            for(int i = 1 ; i<=10 ; i++) {
        %>
               <%=a * i %>
               </br>
       <%
            }
        %>

        <%!
            int x = 100;
            static int y = 200;
            public void m() {
                System.out.println("m() function from JSP Page");
            }
        %>

        <%
            m();
        %>









    </body>
</html>