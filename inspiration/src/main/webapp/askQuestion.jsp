<%-- 
    Document   : homepage
    Created on : Nov 21, 2015, 1:53:27 PM
    Author     : Andrew Garver
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/modules/head.jsp" />
        <title>Ask a question</title>
    </head>
    <body>
        <jsp:include page="/modules/header.jsp" />
        <div class="userInfo">
            <div class="col-md-10">
                <form action="AskQuestion" method="post">
                    
                    <input class="form-control" type="text" style="max-width: 40%; float:left;" placeholder="Question title" name="question_title">
                    
                    <select id="category" name="question_topic" style="margin-left:20px;">
                            <!-- This list should pull from the database. -->
                            <option value="1">Mathematics</option>
                            <option value="2">Literature</option>
                            <option value="3">Economics</option>
                            <option value="4">Homemaking</option>
                            <option value="5">Computer Science</option>
                            <option value="6">Web Design</option>
                            <option value="7">Athletics</option>
                    </select><br/>
                    <br>
                    <textarea class="form-control" rows="5" name="question_content" id="question" placeholder="Question text goes here..."></textarea>
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
                <h3 class="submitError">${questionError}</h3>
                <jsp:include page="/modules/sectionListings.jsp" />
            </div>
        </div>
    </body>
</html>
