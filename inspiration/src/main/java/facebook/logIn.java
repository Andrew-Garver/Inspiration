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
        
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String OS_MYSQL_DB_HOST = getenv("OPENSHIFT_MYSQL_DB_HOST");
    static final String OS_MYSQL_DB_PORT = getenv("OPENSHIFT_MYSQL_DB_PORT");
    static final String DB_URL = "jdbc:mysql://" + OS_MYSQL_DB_HOST + ":" + OS_MYSQL_DB_PORT + "/";

    //  Database credentials
    static final String USER = "adminLGMn6AW";
    static final String PASS = "Lhh3jeWDXKe1";
    
    Statement stmt = null;
    Connection conn = null;

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
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String pass = (String) request.getSession().getAttribute("password");
            String sql = "";
            if(request.getSession().getAttribute("email") != null){
                String email = (String) request.getSession().getAttribute("email");
                sql = "SELECT user_id FROM users WHERE email = '" + email + "'";
            } else if(request.getSession().getAttribute("email") != null){
                String username = (String) request.getSession().getAttribute("username");
                sql = "SELECT user_id FROM users WHERE username = '" + username + "'";
            }
            ResultSet rs = stmt.executeQuery(sql);
        } catch(SQLException se) {
      //Handle errors for JDBC
      se.printStackTrace();
   } catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   } finally {
      //finally block used to close resources
      try {
         if(stmt!=null)
            stmt.close();
      } catch(SQLException se2) {
      }// nothing we can do
      try {
         if(conn!=null)
            conn.close();
      } catch(SQLException se) {
         se.printStackTrace();
      }//end finally try
   }//end try
        
        //processRequest(request, response);
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
