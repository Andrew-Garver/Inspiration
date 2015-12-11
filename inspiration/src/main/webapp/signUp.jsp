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
                    <button onClick="window.location.href='facebookLogin'"  type="button" class="btn btn-primary btn-lg" name="SignUp" id="SignUp">Login with Facebook</button><br><br>
                    <form action="SignUp" method="post">
                        <h4>Or, create an account below using your email</h4>
                        <span class="warning">${dupeAcct}</span>
                        <div class="row">
                            <div class="col-md-5">
                                Name: <i class="required">*</i><br>
                                <input class="form-control register-input" type="text" name="name" id="name" required autofocus placeholder="Someone Somewhere"><br>
                                Email: <i class="required">*</i><br>                        
                                <input class="form-control register-input" type="email" name="email" id="email" required placeholder="someone@somewhere.com"><br>
                                Personal Website:  <br>
                                <input class="form-control register-input" type="text" name="website" id="website" placeholder="www.someone.com"><br>
                                LinkedIn:  <br>
                                <input class="form-control register-input" type="text" name="linkedin" id="linkedin" placeholder="https://www.linkedin.com/in/someone"><br>
                                Picture URL:  <br/>
                                <input class="form-control register-input" type="text" name="picurl" id="picurl" placeholder="www.photobucket.com/someone/me.jpg"><br>
                            </div>
                            <div class="col-md-5" style="margin-left:20px;">
                                Username: <i class="required">*</i><br>
                                <input class="form-control register-input" type="text" name="username" id="username" required placeholder="sum1sum"><br>
                                Birthday:  <i class="required">*</i><br/>
                                <input class="form-control register-input" type="date" name="birthday" id="birthday" required><br>
                                Location:  <br/>
                                <input class="form-control register-input" type="text" name="location" id="location" placeholder="Somewhere, USA"><br>
                                Password: <i class="required">*</i><br>
                                <input class="form-control register-input" type="password" name="password" id="password" required placeholder="P@$$w0rD"><br>
                                Confirm Password: <i class="required">*</i><br>
                                <input class="form-control register-input" type="password" name="password2" id="password2" onchange="checkPassword()" required placeholder="P@$$w0rD"><br>
                                <span class="warning" id="passwordWarning"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                Tell Me About Yourself: <i class="required">*</i>
                                <textarea class="boxsizingBorder" cols=60 rows=5 wrap="hard" name="description" placeholder="I'm really awesome, and you can be, too. Just ask me for advice on anything!"></textarea><br/><br/>
                            </div>
                        </div>
                        <input class="btn btn-primary pull-right" type="submit" value="Register" id="submit"><br><br>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function checkPassword() {
                var pass = document.getElementById("password").value;
                var pass2 = document.getElementById("password2").value;
                if(pass !== pass2) {
                    document.getElementById("passwordWarning").innerHTML = "Passwords do not match";
                    document.getElementById("submit").disabled = true;
                } else {
                    document.getElementById("passwordWarning").innerHTML = "";
                    document.getElementById("submit").disabled = false;
                }
            }
        </script>
    </body>
</html>
