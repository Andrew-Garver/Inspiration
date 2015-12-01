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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inspiration.org</title>
    </head>
    <body>
        <jsp:include page="/modules/header.jsp" />
        <div class="userInfo">
            <div class="col-md-8 center">
                <div class="well form-group form-group-sm">  
                    <button onClick="window.location='facebookLogin'"  type="button" class="btn btn-primary btn-lg center-block" name="SignUp" id="SignUp">Login with Facebook</button>
                        <br/>
                    <form class="form-inline" action="register" method="POST">
                        <h4>Or, create an account below using your email</h4>
                        <div class="row center">
                            <div class="col-md-4">
                                <label class="form-label" for="username" >Username: </label>
                                <input class="form-control register-input" type="text" name="username" id="username">
                                <br/><br/>
                                <label class="form-label" for="email" > Email: </label>
                                <input class="form-control register-input" type="email" name="email" id="email" required>
                                <br/><br/>
                                <label class="form-label" for="name" >Name: </label>
                                <input class="form-control register-input" type="text" name="name" id="name" required>
                                <br/><br/>
                                <label class="form-label" for="pic" >Pic URL: </label>
                                <input class="form-control register-input" type="text" name="pic" id="pic">
                                <br/><br/>
                            </div>
                            <div class="col-md-4" style="margin-left:20px;">
                                <label class="form-label" for="birthdate" >Birth Date: </label>
                                <input class="form-control register-input" type="date" name="birthdate" id="birthdate">
                                <br/><br/>
                                <label class="form-label" for="location" >Location: </label>
                                <input class="form-control register-input" type="text" name="location" id="location">
                                <br/><br/>
                                <label class="form-label" for="password" >Password: </label>
                                <input class="form-control register-input" type="password" name="password" id="password">
                                <br/><br/>
                                <label class="form-label" for="password2" >Confirm Password: </label>
                                <input class="form-control register-input" type="password" name="password2" id="password2">
                                <br/><br/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <label class="form-label" >About me: </label>
                                <textarea class="form-control" cols=45 rows=5 name="description"></textarea>
                                <br/><br/>
                            </div>
                        </div>
                        <input class="btn btn-info center-block" type="submit" value="Register"><br/>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>
