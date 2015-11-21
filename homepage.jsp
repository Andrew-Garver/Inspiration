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
            Username <button style="margin-left:10px;" type="button">Log out</button>
            </div>
        </div>
        <hr>
        <div class="userInfo">
            <div class="col-md-4"></div>
            <div class="col-md-6"></div>
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
                <div class="panel panel-default">
                    <div class="panel-body">
                        <p style="font-size:24px">Topics</p>
                        <p style="font-size:18px"><a href="#">Mathematics</a></p>
                        <p style="font-size:18px"><a href="#">Literature</a></p>
                        <p style="font-size:18px"><a href="#">Economics</a></p>
                        <p style="font-size:18px"><a href="#">Homemaking</a></p>
                        <p style="font-size:18px"><a href="#">Computer Science</a></p>
                        <p style="font-size:18px"><a href="#">Web Design</a></p>
                        <p style="font-size:18px"><a href="#">Athletics</a></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
