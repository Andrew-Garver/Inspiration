<%-- 
    Document   : getTest
    Created on : Nov 28, 2015, 3:15:09 PM
    Author     : bear
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/modules/head.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test GET method here</h1>
        
        <form method ="GET" action="forumRequest">
            <input name="entry" type="text">
            <button type="submit">SEND</button>
        </form>
        
    </body>
</html>
