<%-- 
    Document   : viewProfile
    Created on : Nov 21, 2015, 11:51:34 AM
    Author     : Andrew Garver
--%>
<%
    if(session.getAttribute("loggedIn") == null) {
        response.sendRedirect("homepage.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/modules/head.jsp" />
        <title>View Profile</title>
    </head>
    <body>
        <jsp:include page="/modules/header.jsp" />
        <div class="userInfo">
            <div class="col-md-4">
                <img class="img-responsive" src="${pic}" alt="User Profile Picture">
                <p class="karma">Karma +234</p>
            </div>
            <div class="col-md-6">
                <h2><% out.print(session.getAttribute("name")); %></h2>
                <p> ${desc}</p>
                <p class="userListDetails">Birthday: <span class="userDetails">${birth_date}</span></p>
                <p class="userListDetails">Age: <span class="userDetails">${age}</span></p>
                <p class="userListDetails">Location:  <span class="userDetails">${loc}</span></p>
                <p class="userListDetails">Social Media</p>
                <p class="userListDetails">Web site</p>
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
