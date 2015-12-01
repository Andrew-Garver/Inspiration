<%-- 
    Document   : homepage
    Created on : Nov 21, 2015, 1:53:27 PM
    Author     : Andrew Garver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="inspiration.css">
        <link href="favicon-32x32.png" rel="icon" type="image/ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inspiration.org</title>
    </head>
    <body>
        <jsp:include page="/modules/header.jsp" />
        <div class="userInfo">
            <div class="col-md-4"></div>
            <div class="col-md-6">
                <h1>Sign in Page</h1><br/>
                <button class="btn btn-lg btn-primary" onClick="window.location='facebookLogin'" type="button" name="SignUp" id="SignUp">Sign in with Facebook</button>
                <br/><br/>
                <h4>Or</h4>
                <form action="logIn" metho="POST" class="form-inline">
                    <h3>Sign in With Email or Username</h3>
                    <br/>
                    <label for="email" class="form-label">Email: </label>
                    <input type="text" class="form-control" name="email" id="email" value="?{email}" autofocus>
                    <br/><br/>
                    <label for="username" class="form-label">Username: </label>
                    <input type="text" class="form-control" name="username" id="username" value="?{username}" autofocus>
                    <br/><br/>
                    <label for="password" class="form-label" >Password: </label>
                    <input type="password" class="form-control" name="password" id="password" required>
                    <br/><br/>
                    <input type="submit" class="btn btn-primary btn-lg" value="Log In">
                </form>
            </div>
            <div class="col-md-2">
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>
