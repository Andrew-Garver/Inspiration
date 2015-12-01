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
        <title>Ask a question</title>
    </head>
    <body>
        <h1><a class="title" href="#">Inspiration.org</a></h1>
        <div class="topLinks">
            <a style="padding-left:4%" href="#">About Inspiration.org</a>
            <a style="padding-left:10px" href="#">Site Rules</a>
            <div class="userButtons">
                <div class="dropdown">
                    <%
                        if (session.getAttribute("loggedIn") != null) {
                            out.print("<button class=\"btn btn-primary dropdown-toggle\" style=\" margin-bottom: 20px;\""
                                    + "type=\"button\" data-toggle=\"dropdown\">"
                                    + session.getAttribute("name")
                                    + " <span class=\"caret\"></span></button>"
                                    + "<ul class=\"dropdown-menu\">"
                                    + "<li><a href=\"viewProfile.jsp\">View/Edit Profile</a></li>"
                                    + "<li><a href=\"askQuestion.jsp\">Ask a question</a></li>"
                                    + "<li><a href=\"#\">Another link</a></li>"
                                    + "</ul>"
                                    + "<a href = \"signOut\">"
                                    + "<button class=\"btn btn-primary\" style=\"margin-left:10px; margin-bottom: 20px;\" type=\"button\">Log out</button>"
                                    + "</a>");
                        } else {
                            out.print("<a href = \"signIn.jsp\""
                                    + "<button class=\"btn btn-success\" onclick =\"login();\" style=\"margin-left:10px; min-width:80px; max-width:80px; margin-bottom:20px\" type=\"button\">Log In</button>"
                                    + "</a>");
                            out.print("<a href = \"signUp.jsp\""
                                    + "<button class=\"btn btn-primary\" style=\"margin-left:10px; min-width:80px; max-width:80px; margin-bottom:20px\" type=\"button\">Sign Up</button>"
                                    + "</a>");
                        }
                    %>
                </div>
            </div>
        </div>
        <hr>
        <div class="userInfo">
            <div class="col-md-10">
                <form action="AskQuestion" method="post">
                    
                    <input class="form-control" type="text" style="max-width: 40%; float:left;" placeholder="Question title">
                    
                    <div>
                        <select id="category" style="margin-left:20px;">
                            <option>Mathematics</option>
                            <option>Literature</option>
                            <option>etc.</option>
                            <option>etc..</option>
                        </select>
                    </div>
                    <br>
                    <textarea class="form-control" rows="5" name="question" id="question" placeholder="Question text goes here..."></textarea>
                    <br><input class="btn btn-primary" type="submit" value="Submit">
                </form>

            </div>
            <div class="col-md-2">
                <form action="#" method="post">
                    <div id="custom-search-input">
                        <div class="input-group col-md-12">
                            <input type="text" class="search-query form-control" placeholder="Search" name="keyword" />
                            <span class="input-group-btn">
                                <button class="btn btn-danger" type="submit">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                    </div>
                </form>
                <jsp:include page="sectionListings.jsp" />
            </div>
        </div>
    </body>
</html>
