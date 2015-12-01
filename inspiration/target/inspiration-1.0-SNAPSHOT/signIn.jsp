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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inspiration.org</title>
    </head>
    <body>
        <h1><a class="title" href="homepage.jsp">Inspiration.org</a></h1>
        <div class="topLinks">
            <a style="padding-left:4%" href="#">About Inspiration.org</a>
            <a style="padding-left:10px" href="#">Site Rules</a>
            <div class="userButtons">
              <div class="dropdown">
                                  <%
                      if(session.getAttribute("loggedIn") != null) {
                          out.print("<button class=\"btn btn-primary dropdown-toggle\" style=\" margin-bottom: 20px;\"" +
                                    "type=\"button\" data-toggle=\"dropdown\">" +
                                    session.getAttribute("name") +
                                    " <span class=\"caret\"></span></button>" +
                                    "<ul class=\"dropdown-menu\">" +
                                    "<li><a href=\"viewProfile.jsp\">View/Edit Profile</a></li>" +
                                    "<li><a href=\"askQuestion.jsp\">Ask a question</a></li>" +
                                    "<li><a href=\"#\">Another link</a></li>" +
                                    "</ul>" +
                                    "<a href = \"signOut\">" +
                                    "<button class=\"btn btn-primary\" style=\"margin-left:10px; margin-bottom: 20px;\" type=\"button\">Log out</button>" +
                                    "</a>");
                      }
                      else {
                          out.print("<a href = \"signIn.jsp\"" +
                                    "<button class=\"btn btn-success\" onclick =\"login();\" style=\"margin-left:10px; min-width:80px; max-width:80px; margin-bottom:20px\" type=\"button\">Log In</button>" +
                                    "</a>");
                          out.print("<a href = \"signUp.jsp\"" +
                                    "<button class=\"btn btn-primary\" style=\"margin-left:10px; min-width:80px; max-width:80px; margin-bottom:20px\" type=\"button\">Sign Up</button>" + 
                                    "</a>");
                      }
                      %>
              </div>
            </div>
        </div>
        <hr>
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
