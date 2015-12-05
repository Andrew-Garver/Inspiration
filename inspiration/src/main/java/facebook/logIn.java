/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.getenv;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cswor
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
        if (request.getSession().getAttribute("email") != null) {
            String email = (String) request.getParameter("email");
            sql = "SELECT user_id FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
        } else {
            String username = (String) request.getParameter("username");
            sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        }
        dbConnection db = new dbConnection();
        db.setConnections();
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs;
        try {
            Class.forName(db.getJDBC_DRIVER());
            conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                request.getSession().setAttribute("loggedIn", "true");
                request.getSession().setAttribute("name", rs.getString("name"));
                request.getSession().setAttribute("pic", rs.getString("pic"));
                request.getSession().setAttribute("desc", rs.getString("desc"));
                request.getSession().setAttribute("birth_date", new SimpleDateFormat("MM-dd-yyyy").format(rs.getString("birth_date")));
                LocalDate now = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate birth_date = LocalDate.parse(rs.getString("birth_date"), formatter);
                Period age = Period.between(birth_date, now);
                request.getSession().setAttribute("badLogin", "");
                response.sendRedirect("homepage.jsp");
            } else {
                request.setAttribute("badLogin", "Invalid login credentials");
                response.sendRedirect("signIn.jsp");
            }
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception se) {
            request.getSession().setAttribute("badLogin", "Getting an exception when trying to log in...");
            response.sendRedirect("signIn.jsp");
        } finally {
            //finally block used to close resources
            try {
                if(stmt != null)
                    stmt.close();
            } catch(SQLException se2) {
        }// nothing we can do
            try {
                if(conn != null)
                conn.close();
            } catch(SQLException se) {
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
