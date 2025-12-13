<html>
    <head>
        <title>Search Details</title>
    </head>
    <body>
    <%
        String value = "";
        Cookie[] cookies = request.getCookies();
        if(cookies !=null && cookies.length>0) {
            for(Cookie ck : cookies) {
                String name = ck.getName();
                if("usersearch1".equals(name)) {
                    value = ck.getValue();
                    break;
                }
            }
        }
    %>
    <% if(!value.isEmpty()) {%>
        <h3>Your Previous Search: <%= value %></h3>
    <% } %>
        <form action='result'>
            Search For : <input type='text' name='query'>
            <br/><br/>
            <button type='submit'>Search</button>
        </form>
    </body>
</html>