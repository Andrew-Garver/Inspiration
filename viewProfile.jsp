<%-- 
    Document   : viewProfile
    Created on : Nov 21, 2015, 11:51:34 AM
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
        <title>View Profile</title>
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
            <div class="col-md-4">
                <img class="img-responsive" src="defaultUserPic.png" alt="User Profile Picture">
                <p style="text-align: center; font-size: 46px">A. Real Name</p>
                <p style="text-align: center; font-size: 32px">Karma +234</p>
            </div>
            <div class="col-md-6">
                <h2>About A. Real Name</h2>
                <h4>
                    Lorem ipsum dolor sit amet, maiores ornare ac fermentum, imperdiet ut vivamus a, 
                    nam lectus at nunc. Quam euismod sem, semper ut potenti pellentesque quisque. In 
                    eget sapien sed, sit duis vestibulum ultricies, placerat morbi amet vel, nullam in 
                    in lorem vel. In molestie elit dui dictum, praesent nascetur pulvinar sed, in dolor
                    pede in aliquam, risus nec error quis pharetra. Eros metus quam augue suspendisse,
                    metus rutrum risus erat in.  In ultrices quo ut lectus, etiam vestibulum urna a est,
                    pretium luctus euismod nisl, pellentesque turpis hac ridiculus massa. Venenatis a taciti 
                    dolor platea, curabitur lorem platea urna odio, convallis sit pellentesque lacus proin. 
                    Et ipsum velit diam nulla, fringilla vel tincidunt vitae, elit turpis tellus vivamus, 
                    dictum adipiscing convallis magna id. Viverra eu amet sit, dignissim tincidunt volutpat 
                    nulla tincidunt, feugiat est erat dui tempor, fusce tortor auctor vestibulum. Venenatis 
                    praesent risus orci, ante nam volutpat erat. Cursus non mollis interdum maecenas, consequat 
                    imperdiet penatibus enim, tristique luctus tellus eos accumsan, ridiculus erat laoreet nunc.
                </h4>
                <h3>Age 37</h3>
                <h3>Location The Alps</h3>
                <h3>Social Media</h3>
                <h3>Web site</h3>
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
