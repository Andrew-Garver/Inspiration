<%-- 
    Document   : viewPosts
    Created on : Nov 25, 2015, 7:48:15 PM
    Author     : cswor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png" type="image/png">
        <title>View Posts</title>
    </head>
    <body class="container" onload="getPosts()">
        <c:choose>
            <c:when test="${not empty username}">
                <h1>Welcome ${username}</h1>
                <h2>Topic: What do you like most about JSP?</h2>
                <br/>
                <p>So Far, People Have Posted...</p>
                <br/>
                <div>
                    <c:forEach var="post" items="${posts}"> 
                        ${post.toString()}<br/> 
                    </c:forEach>
                </div> <!-- Posts div -->
                <br/>
                <form action="addPost" method="POST">
                    <h3>Post content:</h3>
                    <textarea id="content" class="form-control" type="text" placeholder="My opinion is ____. (500 characters or less)" maxlength="500" rows="5" autofocus required></textarea>
                    <br/><br/>
                    <input id="addPost" class="btn btn-primary" type="submit" value="Add Reply">
                </form>
            </c:when>
            <c:otherwise>
                <h1>You are not signed in!?</h1>
                <p>Please <a href="login.jsp">sign in</a> to view content...</p>
            </c:otherwise>
        </c:choose>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/getPosts.js"></script>
    </body>
</html>
