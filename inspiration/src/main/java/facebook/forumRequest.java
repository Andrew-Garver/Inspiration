/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bear
 */
@WebServlet(name = "forumRequest", urlPatterns = {"/forumRequest"})
public class forumRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected String getHeaderInfo() {
        String header = "<!DOCTYPE html>\n" +
                        "<html>\n" + 
                        "    <head>\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <link rel=\"stylesheet\" type=\"text/css\" href=\"ref.css\">\n" +
                        "        <title>JSP Page</title>\n" +
                        "    </head>";
        return header;
    }
    
    protected String getNewBox(){
            String beginBox =   "    <div class=\"detailBox\">\n" +
                                "    <div class=\"titleBox\">\n" +
                                "      <label>Responses</label>\n" +
                                "    </div>        \n" +
                                "    <div class=\"actionBox\">\n" +
                                "        <ul class=\"commentList\">";
            return beginBox;
    }

    protected String getResponse(){
            String content =    "            <li>\n" +
                                "                <div class=\"commenterImage\">\n" +
                                "                  <img src=\"http://lorempixel.com/50/50/people/6\" />\n" +
                                "                </div>\n" +
                                "                <div class=\"commentText\">\n" +
                                "                    <p>Hello this is a test comment.</p> <span class=\"date sub-text\">on March 5th, 2014</span>\n" +
                                "\n" +
                                "                </div>\n" +
                                "            </li>";
            return content;
    }
        
    protected String getEndNewBox(){
            String endBox = "        <form action=\"PostComment\" method=\"post\" class=\"form-inline\" role=\"form\">\n" +
                            "            <div class=\"form-group\">\n" +
                            "                <input class=\"form-control\" type=\"text\" placeholder=\"Your comments\" />\n" +
                            "            </div>            \n" +
                            "            <div class=\"form-group\">\n" +
                            "                <input type=\"submit\" value=\"Add\" class=\"btn btn-default\">\n" +
                            "            </div>\n" +
                            "        </form>";
            return endBox;
    }

    protected String getEndHTML(){
            String end =    "<!DOCTYPE html>\n" +
                            "<html>\n    <head>";
            return end;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet forumRequest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet forumRequest at " + request.getContextPath() + "</h1>");
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
        
        String getID = request.getParameter("entry");
 
        Vector<Integer> posterIDs = new Vector<>();        
        Vector<String> titles = new Vector<>();        
        Vector<String> topics = new Vector<>();        

        // Define our constants
        String DB_URL = "jdbc:mysql://localhost/jsp";
        String USER = "adminLGMn6AW";
        String PASS = "Lhh3jeWDXKe1";
        
        // Connect to our database
        Connection conn = null;
        Statement  stmt = null;
        String SQL = "SELECT * FROM posts WHERE post_id = " + getID;
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Loads a class in by a dynamic string's name vs static naming conventions    
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(SQL);
                        
            while(rs.next()) {
                // Grab variables
                Integer tempID   = rs.getInt("post_id");
                String tempTitle = rs.getString("title");
                String tempTopic = rs.getString("topic");
                
                // Store them
                posterIDs.add(tempID);
                titles.add(tempTitle);
                topics.add(tempTopic);                
            }
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
         
                
        try (PrintWriter out = response.getWriter()) {
            out.println(getHeaderInfo());

            // Dynamic content testing
            out.println("<h1>GET Entry REQUEST FOR " + getID + "</h1>");
            for(int i = 0; i < topics.size(); i++) 
                out.println("<h1>" + topics.get(i) + "</h1>");
            out.println("<h1>Topics #: " + topics.size() + "</h1>");
            
            
            out.println(getNewBox());
            out.println(getResponse());
            out.println(getEndNewBox());
            out.println(getEndHTML());
        }
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

    private void forName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
