<%-- 
    Document   : homepage
    Created on : Nov 21, 2015, 1:53:27 PM
    Author     : Andrew Garver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/modules/head.jsp" />
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
                    <label for="email" class="form-label">Email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <input type="text" class="form-control" name="email" id="email" value="${email}" onchange="validate()" autofocus>
                    <br/><br/>
                    <label for="username" class="form-label">Username: </label>
                    <input type="text" class="form-control" name="username" id="username" value="${username}" onchange="validate()" minlength="5">
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
        <script>
            function validate() {
                if(document.getElementById("email").value.length == 0 &&
                        document.getElementById("username").value.length == 0) {
                    document.getElementById("username").disabled = false;
                    document.getElementById("email").disabled = false;
                } else if(document.getElementById("email").value.length > 0) {
                    document.getElementById("username").disabled = true;
                    document.getElementById("email").disabled = false;
                } else if(document.getElementById("username").value.length > 0) {
                    document.getElementById("email").disabled = true;
                    document.getElementById("username").disabled = false;
                }
            }
        </script>
    </body>
</html>
