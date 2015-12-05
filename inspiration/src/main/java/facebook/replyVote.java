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
 * @author bear
 */
@WebServlet(name = "replyVote", urlPatterns = {"/replyVote"})
public class replyVote extends HttpServlet {

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
            out.println("<title>Servlet replyVote</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet replyVote at " + request.getContextPath() + "</h1>");
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

        String referer = request.getHeader("Referer");
        if(referer.equals(""))
            referer="lds.org";


        String voterID = "1";//request.getSession().getAttribute("user_id"); <--- IMPLEMENT ONLY WITH FUNCTIONAL LOGIN CODE/ADAPT AS NEEDED
        String authorID = ""; // We look up this value
        String replyNumber= request.getParameter("replyID");
        String vote = request.getParameter("val");
                
        Integer vote_id = -1;
        
        // Lookup the author of the post
        String replyAuthorSQL = "SELECT * FROM replies where reply_id=" + replyNumber;

        // Lookup the vote information
        String previousVote = "NO VOTE";
        String previousVoteSQL = "SELECT * FROM reply_votes WHERE reply_id=" + replyNumber + " AND user_id="+ voterID;        
        
        dbConnection db = new dbConnection();
        db.setConnections();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
            stmt = conn.createStatement();

            // Get the Author's id
            rs = stmt.executeQuery(replyAuthorSQL);
            if(rs.next()) {
                authorID = Integer.toString(rs.getInt("user_id"));
            }

            // Get the Post's information
            rs = stmt.executeQuery(previousVoteSQL);
            
            // Grab the previous entry if there is one already stored
            if(rs.next()) {
                previousVote = rs.getString("vote");
                vote_id = rs.getInt("reply_votes_id");
            }            
            
            // Reset the statment data
            stmt.close();
            stmt = conn.createStatement();
            if(previousVote.equals("NO VOTE")) { // First time casting a vote on this reply
                String dif ="+ 1";
                
                if(vote.equals("down")) {
                    dif="- 1";
                }
                
                String addRowSQL = "INSERT INTO reply_votes (reply_id, user_id, vote) VALUES (" + replyNumber + ", " + voterID + ", \"" + vote + "\")";
                String updateReplyKarmaSQL = "UPDATE replies SET karma_total=karma_total" + dif + " WHERE reply_id=" + replyNumber;
                String updateUserKarmaSQL ="UPDATE users SET karma_total=karma_total" + dif + " WHERE user_id=" + authorID;
                
                stmt.executeUpdate(addRowSQL);
                stmt.executeUpdate(updateReplyKarmaSQL);
                stmt.executeUpdate(updateUserKarmaSQL);
            }
            else if(previousVote.equals(vote)) { // Vote is the same as before
                ; // Do nothing
            }
            else { // This is a different vote from the one previously made
                String dif ="+ 1";
                if(vote.equals("down"))
                    dif="- 1";
                String deleteVote = "DELETE from reply_votes where reply_votes_id=" + vote_id;
                String updateReplyKarmaSQL = "UPDATE replies SET karma_total=karma_total" + dif + " WHERE reply_id=" + replyNumber;
                String updateUserKarmaSQL ="UPDATE users SET karma_total=karma_total" + dif + " WHERE user_id=" + authorID;

                stmt.executeUpdate(deleteVote);
                stmt.executeUpdate(updateReplyKarmaSQL);
                stmt.executeUpdate(updateUserKarmaSQL);
            }            
        } catch(ClassNotFoundException e) {            
            e.getMessage();
            e.printStackTrace();
        } catch(Exception d) {
            d.printStackTrace();
        } finally { // Clean up! Clean up! Everybody clean up!
            try {
                if(stmt != null)
                    stmt.close();
            } catch(Exception se) { 
                    se.printStackTrace();
            } try {
                if(conn != null)
                    conn.close();
            } catch(Exception se) {
                    se.printStackTrace();
            }
        }
        // Send the user back to the previous page they were on
        response.sendRedirect(referer);
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
        processRequest(request, response);
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
