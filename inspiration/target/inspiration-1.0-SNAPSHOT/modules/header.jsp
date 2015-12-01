<h1><a class="title" href="/inspiration/homepage.jsp"><img src="ms-icon-70x70.png" title="Home Page">Inspiration.org</a></h1>
<div class="topLinks">
    <a style="padding-left:4%" href="#">About Inspiration.org</a>
    <a style="padding-left:10px" href="#">Site Rules</a>
    <div class="userButtons">
        <div class="dropdown">
            <%
                if (session.getAttribute("loggedIn") != null) {
                    out.print("<button class=\"btn btn-primary dropdown-toggle\" style=\" margin-bottom: 20px;\""
                            + "type=\"button\" data-toggle=\"dropdown\">"
                            + session.getAttribute("name")
                            + " <span class=\"caret\"></span></button>"
                            + "<ul class=\"dropdown-menu\">"
                            + "<li><a href=\"viewProfile.jsp\">View/Edit Profile</a></li>"
                            + "<li><a href=\"askQuestion.jsp\">Ask a question</a></li>"
                            + "<li><a href=\"#\">Another link</a></li>"
                            + "</ul>"
                            + "<a href = \"signOut\">"
                            + "<button class=\"btn btn-primary\" style=\"margin-left:10px; margin-bottom: 20px;\" type=\"button\">Log out</button>"
                            + "</a>");
                } else {
                    out.print("<a href = \"signIn.jsp\""
                            + "<button class=\"btn btn-success\" onclick =\"login();\" style=\"margin-left:10px; min-width:80px; max-width:80px; margin-bottom:20px\" type=\"button\">Log In</button>"
                            + "</a>");
                    out.print("<a href = \"signUp.jsp\""
                            + "<button class=\"btn btn-primary\" style=\"margin-left:10px; min-width:80px; max-width:80px; margin-bottom:20px\" type=\"button\">Sign Up</button>"
                            + "</a>");
                }
            %>
        </div>
    </div>
</div>
<hr>
