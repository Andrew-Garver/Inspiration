/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.getenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew Garver
 */
@WebServlet(name = "AskQuestion", urlPatterns = {"/AskQuestion"})
public class AskQuestion extends HttpServlet {

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
            out.println("<title>Servlet AskQuestion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AskQuestion at " + request.getContextPath() + "</h1>");
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
        
        // Add information to database here.
        
//        processRequest(request, response);
        // Define our constants
        String DB_URL = "jdbc:mysql://localhost/jsp";
//        String OS_MYSQL_DB_HOST = getenv("OPENSHIFT_MYSQL_DB_HOST");
//        String OS_MYSQL_DB_PORT = getenv("OPENSHIFT_MYSQL_DB_PORT");
//        String DB_URL = "jdbc:mysql://" + OS_MYSQL_DB_HOST + ":" + OS_MYSQL_DB_PORT + "/";

//        String USER = "adminLGMn6AW";
//        String PASS = "Lhh3jeWDXKe1";
        String USER = "root";
        String PASS = "";
        
//        String userID = request.getSession().getAttribute("id").toString();
        String user_id = "1";
        String post_id = "9";
        String postTitle = request.getParameter("question_title");
        String postContent = request.getParameter("question_content");
        PrintWriter out = response.getWriter();
        out.println(user_id + " " + post_id + " " + postTitle + " " + postContent);
        
        // Connect to our database
        Connection conn = null;
        Statement  stmt = null;
        String SQL = "INSERT INTO posts (user_id, post_id, title, content) VALUES ("
                + user_id + ", "
                + post_id + ", "
                + postTitle + ", "
                + postContent + ")";
        boolean executeStatus = false;
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Loads a class in by a dynamic string's name vs static naming conventions    
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            stmt.executeUpdate(SQL);
        }catch(ClassNotFoundException e) {
            out.println(e.getMessage());
            e.printStackTrace();
        }catch(Exception d) {
            d.printStackTrace();
            out.println(SQL);
            out.println(d.getMessage());

        }finally{ // Clean up! Clean up! Everybody clean up!
            try{
                if(stmt != null)
                    stmt.close();}
                catch(Exception se){ 
                    se.printStackTrace();}
            try{
                if(conn != null)
                    conn.close();}
                catch(Exception se) {
                    se.printStackTrace();}
        }
//        response.sendRedirect("forumRequest?entry=" + post_id); // comment this out to test the data we're posting
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
