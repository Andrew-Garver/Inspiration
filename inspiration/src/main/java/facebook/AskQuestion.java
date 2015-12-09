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
import java.sql.SQLException;
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
        String user_id = request.getSession().getAttribute("user_id").toString();
        String sql = "SELECT MAX(post_id) + 1 AS id FROM posts";
        String post_id = null;
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
            if(rs.next()) {
                post_id = rs.getString("id");
            }
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception se) {
            request.getSession().setAttribute("questionError", "Getting an exception when trying to log in...");
            response.sendRedirect("askQuestion.jsp");
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
            
        String postTitle = request.getParameter("question_title");
        String postContent = request.getParameter("question_content");
        String postParentTopic = request.getParameter("question_topic");
        PrintWriter out = response.getWriter();
        String postType = "question";
        out.println("userid: " + user_id + " post_id: " + post_id + " post-title: " + postTitle + " post-content: " + postContent + " post-type: " + postType + " post-parent-topic: " + postParentTopic);
        
//        Connect to our database
        sql = "INSERT INTO posts (user_id, post_id, title, content, type, topic_id) VALUES ("
                + user_id + ", "
                + post_id + ", "
                + "'" + postTitle + "'" + ", "
                + "'" + postContent + "'" + ", "
                + "'" + postType + "'" + ", "
                + postParentTopic + ")";
        stmt = null;
        conn = null;
        try {
            Class.forName(db.getJDBC_DRIVER());
            conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception se) {
            request.getSession().setAttribute("questionError", "Getting an exception when trying to post your question...");
            response.sendRedirect("askQuestion.jsp");
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
        response.sendRedirect("forumRequest?entry=" + post_id); // comment this out to test the data we're posting
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
