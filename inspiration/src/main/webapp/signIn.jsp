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
                    <form>
                        <h1>Sign in Page</h1><br/>
                        <button onClick="window.location.href='facebookLogin'" type="button" name ="SignUp" id ="SignUp">Sign in with Facebook</button>
                        <br/>
                        <br/>
                        <h4>Or</h4>
                        <h3>Sign in with your email address</h3>
                        Email: <br/>                        
                        <input type ="text" name ="email" id="email"><br/><br/>
                        Password: <br>
                        <input type="password" name="password" id="password"><br><br>
                        <input type="submit" value ="Submit form">
                        <br/>
                        <br/>
                        <br/>
                    </form>
            </div>
            <div class="col-md-2">
            </div>
        </div>
    </body>
</html>
