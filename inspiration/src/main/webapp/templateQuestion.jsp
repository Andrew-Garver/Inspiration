<%-- 
    Document   : templateQuestion
    Created on : Nov 23, 2015, 2:01:39 PM
    Author     : Dane & Andrew
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ref.css">
        <title>JSP Page</title>
    </head>
    <body>            
        
        
        
    <div class="detailBox">
    <div class="titleBox">
      <label>Responses</label>
    </div>        
    <div class="actionBox">
        <ul class="commentList">           
            
            
            <li>
                <div class="commenterImage">
                  <img src="http://lorempixel.com/50/50/people/6" />
                </div>
                <div class="commentText">
                    <p>Hello this is a test comment.</p> <span class="date sub-text">on March 5th, 2014</span>

                </div>
            </li>                 

        
            
            
        <form class="form-inline" role="form">
            <div class="form-group">
                <input class="form-control" type="text" placeholder="Your comments" />
            </div>            
            <div class="form-group">
                <button class="btn btn-default">Add</button>
            </div>
        </form>




            
            
            
            
            
            

    </div>
</div>
    </body>
</html>
