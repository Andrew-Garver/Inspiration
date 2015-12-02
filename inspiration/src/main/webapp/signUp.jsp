<%-- 
    Document   : homepage
    Created on : Nov 21, 2015, 1:53:27 PM
    Author     : Andrew Garver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/modules/head.jsp" />
        <title>Inspiration.org</title>
    </head>
    <body>
        <jsp:include page="/modules/header.jsp" />
        <div class="userInfo">
            <div style="width:500px;margin:auto auto;">
                <div class="well form-group form-group-sm">  
                    <button onClick="window.location.href='facebookLogin'"  type="button" class="btn btn-primary" name="SignUp" id="SignUp">Login with Facebook</button><br><br>
                    <form>
                        <h4>Or, create an account below using your email</h4>
                        <div class="row">
                            <div class="col-md-5">
                                Email: <br>                        
                                <input class="form-control register-input" type="email" name="email" id="email" required><br>
                                Name: <br>
                                <input class="form-control register-input" type="text" name="name" id="name" required><br>
                                Description:  <br>
                                <input class="form-control register-input" type="text" name="description" id="description"><br>
                                Pic URL:  <br/>
                                <input class="form-control register-input" type="text" name="url" id="url"><br>
                            </div>
                            <div class="col-md-5" style="margin-left:20px;">
                                Age:  <br/>
                                <input class="form-control register-input" type="text" name="age" id="age"><br>
                                Location:  <br/>
                                <input class="form-control register-input" type="text" name="location" id="location"><br>
                                Password: <br>
                                <input class="form-control register-input" type="password" name="password" id="password"><br>
                                Confirm Password: <br>
                                <input class="form-control register-input" type="password" name="password" id="password"><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                About me:
                                <textarea class="form-control" cols=45 rows=5 name="about"></textarea><br/><br/>
                            </div>
                        </div>
                        <input class="btn btn-default pull-right" type="submit" value="Register"><br><br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
