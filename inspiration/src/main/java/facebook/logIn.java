/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author csworen
 */
@WebServlet(name = "logIn", urlPatterns = {"/logIn"})
public class logIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet logIn</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet logIn at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sql;
        request.getSession().setAttribute("badLogin", "Invalid login credentials");
        PrintWriter out = response.getWriter();
        String password = (String) request.getParameter("password");
        out.println(password);
        if (request.getParameter("email") != null) {
            String email = (String) request.getParameter("email");
            out.println(email);
            sql = "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
        } else {
            String username = (String) request.getParameter("username");
            out.println(username);
            sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        }
        dbConnection db = new dbConnection();
        db.setConnections();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                out.println("Connected to db");
                request.getSession().setAttribute("loggedIn", "true");
                request.getSession().setAttribute("name", rs.getString("username"));
                request.getSession().setAttribute("pic", rs.getString("pic"));
                request.getSession().setAttribute("desc", rs.getString("desc"));
                request.getSession().setAttribute("location", rs.getString("location"));
                request.getSession().setAttribute("user_id", rs.getString("user_id"));
                request.getSession().setAttribute("email", rs.getString("email"));
                request.getSession().setAttribute("faebook", rs.getString("facebook"));
                request.getSession().setAttribute("linked_in", rs.getString("linked_in"));
                request.getSession().setAttribute("website", rs.getString("personal_site"));
                request.getSession().setAttribute("join_date", rs.getString("join_date"));
                request.getSession().setAttribute("birth_date", rs.getString("birth_date"));
                out.println("assigned session vars");
                Calendar today = Calendar.getInstance();
                Calendar birth_date = Calendar.getInstance();
                birth_date.setTime(rs.getDate("birth_date"));
                int age = today.get(Calendar.YEAR) - birth_date.get(Calendar.YEAR);
                request.getSession().setAttribute("age", age);
                request.getSession().setAttribute("badLogin", "");
                response.sendRedirect("homepage.jsp");
            } else {
                out.println("creds wrong");
                request.setAttribute("badLogin", "Invalid login credentials");
                response.sendRedirect("signIn.jsp");
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            out.println("Could not connect to db");
            se.printStackTrace();
        } catch (Exception se) {
            out.println("exception thrown std");
            request.getSession().setAttribute("badLogin", "Getting an exception when trying to log in...");
            se.printStackTrace();
            response.sendRedirect("signIn.jsp");
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
