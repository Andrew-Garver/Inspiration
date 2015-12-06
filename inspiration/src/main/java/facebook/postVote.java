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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bear
 */
@WebServlet(name = "postVote", urlPatterns = {"/postVote"})
public class postVote extends HttpServlet {

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
            out.println("<title>Servlet postVote</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet postVote at " + request.getContextPath() + "</h1>");
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


        String voterID = "1";//USER_ID NEEDS TO BE defined
        String authorID = "";  
        String postNumber= request.getParameter("postID");
        String vote = request.getParameter("val");
                
        Integer vote_id = -1;

        // Lookup the author of the post
        String postAuthorSQL = "SELECT * FROM posts where post_id=" + postNumber;
        
        // Lookup the vote status
        String previousVote = "NO VOTE";
        String previousVoteSQL = "SELECT * FROM post_votes WHERE post_id=" + postNumber + " AND user_id="+ voterID;
        
        dbConnection db = new dbConnection();
        db.setConnections();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs;
        try {
            Class.forName(db.getJDBC_DRIVER());
            conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
            stmt = conn.createStatement();

            // Get the Author's id
            rs = stmt.executeQuery(postAuthorSQL);
            if(rs.next()) {
                authorID = Integer.toString(rs.getInt("user_id"));
            }                        
            
            // Get the Post's information
            rs = stmt.executeQuery(previousVoteSQL);
            
            // Grab the previous entry if there is one already stored
            if(rs.next()) {
                previousVote = rs.getString("vote");
                vote_id = rs.getInt("post_votes_id");
            }
                        
            // Reset the statment data
            stmt.close();
            stmt = conn.createStatement();
            if(previousVote.equals("NO VOTE")) { // First time casting a vote on this post
                String dif ="+ 1";
                
                if(vote.equals("down")) {
                    dif="- 1";
                }
                
                String addRowSQL = "INSERT INTO post_votes (post_id, user_id, vote) VALUES (" + postNumber + ", " + voterID + ", \"" + vote + "\")";       
                String updatepostKarmaSQL = "UPDATE posts SET karma_total=karma_total" + dif + " WHERE post_id=" + postNumber;
                String updateUserKarmaSQL ="UPDATE users SET karma_total=karma_total" + dif + " WHERE user_id=" + authorID;
                
                stmt.executeUpdate(addRowSQL);
                stmt.executeUpdate(updatepostKarmaSQL);
                stmt.executeUpdate(updateUserKarmaSQL);
            } else if(previousVote.equals(vote)) { // Vote is the same as before
                ; // Do nothing
            } else { // This is a different vote from the one previously made
                String dif ="+ 1";
                if(vote.equals("down"))
                    dif="- 1";
                String deleteVote = "DELETE from post_votes where post_votes_id=" + vote_id;
                String updatepostKarmaSQL = "UPDATE posts SET karma_total=karma_total" + dif + " WHERE post_id=" + postNumber;
                String updateUserKarmaSQL ="UPDATE users SET karma_total=karma_total" + dif + " WHERE user_id=" + authorID;

                stmt.executeUpdate(deleteVote);
                stmt.executeUpdate(updatepostKarmaSQL);
                stmt.executeUpdate(updateUserKarmaSQL);
            }            
        } catch(ClassNotFoundException e) {            
            e.getMessage();
            e.printStackTrace();
        } catch(Exception d) {
            d.printStackTrace();
        } finally{ // Clean up! Clean up! Everybody clean up!
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
