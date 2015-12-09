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
                <img class="img-responsive" src="${pic}" alt="User Profile Picture" placeholder="Joined: ${join_date}">
                <p class="karma">Karma: ${karma}</p>
            </div>
            <div class="col-md-6">
                <h2><% out.print(session.getAttribute("name")); %></h2>
                <p> ${desc}</p>
                <p class="userListDetails">Birthday: <span class="userDetails">${birth_date}</span></p>
                <p class="userListDetails">Age: <span class="userDetails">${age}</span></p>
                <p class="userListDetails">Location:  <span class="userDetails">${location}</span></p>
                <p class="userListDetails">Email: <span class="userDetails">${email}</span></p>
                <p class="userListDetails">Linked In: <span class="userDetails">${linked_id}</span></p>
                <p class="userListDetails">Facebook: <span class="userDetails">${facebook}</span></p>
                <p class="userListDetails">Personal Website: <span class="userDetails">${website}</span></p>
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
                <jsp:include page="/modules/sectionListings.jsp" />
            </div>
        </div>
    </body>
</html>
