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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inspiration.org</title>
    </head>
    <body>
        <h1><a class="title" href="#">Inspiration.org</a></h1>
        <div class="topLinks">
            <a style="padding-left:4%" href="#">About Inspiration.org</a>
            <a style="padding-left:10px" href="#">Site Rules</a>
            <div class="userButtons">
              <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" style=" margin-bottom: 20px;"
                        type="button" data-toggle="dropdown">Username
                <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="viewProfile.jsp">View/Edit Profile</a></li>
                    <li><a href="#">Some link</a></li>
                    <li><a href="#">Another link</a></li>
                </ul>
                  <button class="btn btn-primary" style="margin-left:10px; margin-bottom: 20px;" type="button">Log out</button>
              </div>
            </div>
        </div>
        <hr>
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
                        Confirm Password: <br>
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
