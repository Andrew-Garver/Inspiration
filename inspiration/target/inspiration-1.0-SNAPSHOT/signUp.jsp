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
            <div style="width:500px;margin:auto auto;">
                <div class="well form-group form-group-sm">  
                    <button onClick="window.location.href='facebookLogin'"  type="button" class="btn btn-primary" name="SignUp" id="SignUp" disabled>Login with Facebook</button><br><br>
                    <form>
                        <h4>Or, create an account below</h4>
                        <div class="row">
                            <div class="col-md-5">
                                Email: <br>                        
                                <input class="form-control" type="email" name="email" id="email" required><br>
                                Name: <br>
                                <input class="form-control" type="text" name="name" id="name" required><br>
                                Description:  <br>
                                <input class="form-control" type="text" name="description" id="description"><br>
                                Pic URL:  <br/>
                                <input class="form-control" type="text" name="url" id="url"><br>
                            </div>
                            <div class="col-md-5" style="margin-left:20px;">
                                Age:  <br/>
                                <input class="form-control" type="text" name="age" id="age"><br>
                                Location:  <br/>
                                <input class="form-control" type="text" name="location" id="location"><br>
                                Password: <br>
                                <input class="form-control" type="password" name="password" id="password"><br><br>
                                Confirm Password: <br>
                                <input class="form-control" type="password" name="password" id="password"><br><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                About me:
                                <textarea class="form-control" cols=45 rows=5 name="about"></textarea><br/><br/>
                            </div>
                        </div>
                        <input class="btn btn-default pull-right" type="submit" value="Register"><br><br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>