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
        <link href="favicon-32x32.png" rel="icon" type="image/ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ask a question</title>
    </head>
    <body>
        <jsp:include page="/modules/header.jsp" />
        <div class="userInfo">
            <div class="col-md-10">
                <form action="AskQuestion" method="post">
                    
                    <input class="form-control" type="text" style="max-width: 40%; float:left;" placeholder="Question title">
                    
                    <div>
                        <select id="category" style="margin-left:20px;">
                            <!-- This list should pull from the database. -->
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
                <jsp:include page="/modules/sectionListings.jsp" />
            </div>
        </div>
    </body>
</html>