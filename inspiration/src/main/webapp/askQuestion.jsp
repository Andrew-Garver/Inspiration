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
                    <select class="form-control" id="category" name="question_topic" style="max-width: 15%;">
                            <!-- This list should pull from the database. -->
                            <option value="1">Computer Science</option>
                            <option value="2">Web Design</option>
                            <option value="3">Mathematics</option>
                            <option value="4">Athletics</option>
                            <option value="5">Economics</option>
                            <option value="6">Homemaking</option>
                            <option value="7">Literature</option>
                    </select>
                    <br/>
                    <textarea class="form-control" rows="5" name="question_content" id="question" placeholder="Question text goes here..."></textarea>
                    <br><input class="btn btn-primary" type="submit" value="Submit">
                </form>

            </div>
            <div class="stay-right">
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
