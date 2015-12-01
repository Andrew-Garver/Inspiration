/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew Garver
 */
@WebServlet(name = "PostComment", urlPatterns = {"/PostComment"})
public class PostComment extends HttpServlet {

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
            out.println("<title>Servlet PostComment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostComment at " + request.getContextPath() + "</h1>");
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
        
        String getID = request.getParameter("post_id");  

        // Define our constants
        String DB_URL = "jdbc:mysql://localhost/jsp";
        String USER = "adminLGMn6AW";
        String PASS = "Lhh3jeWDXKe1";
        
        // Connect to our database
        Connection conn = null;
        Statement  stmt = null;
        String SQL = "INSERT INTO replies (user_id, post_id, content) VALUES (" + request.getSession().getAttribute("id") + 
                ", " + request.getParameter("post_id") + 
                ", " + request.getParameter("reply") + ")";
        boolean executeStatus;
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Loads a class in by a dynamic string's name vs static naming conventions    
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            executeStatus = stmt.execute(SQL);
        }catch(ClassNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }catch(Exception d) {
            d.printStackTrace();
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
        response.sendRedirect("forumRequest?entry=" + getID);
//        processRequest(request, response);
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
