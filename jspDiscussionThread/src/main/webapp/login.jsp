<%-- 
    Document   : login
    Created on : Nov 23, 2015, 11:54:53 PM
    Author     : cswor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png" type="image/png">
        <title>Login Page</title>
    </head>
    <body class="container">
        <h1>Log In to Join the Discussion</h1>
        <br/>
        <c:if test="${not empty warning}">
            <p>${warning}</p>
        </c:if>
        <form action="signIn" method="post" class="form-inline">
            <div class="form-group">
                <label for="username" class="control-label">User Name: </label>
                <input type="text" class="form-control" name="username" value="${username}" placeholder="admin" required autofocus>
            </div>
            <br/><br/>
            <div class="form-group">
                <label for="password" class="control-label">Password: </label>
                <input type="password" class="form-control" name="password" placeholder="P@55w0rD!" required>
            </div>
            <br/><br/>
            <button type="submit" class="btn btn-primary">Log In</button>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>
