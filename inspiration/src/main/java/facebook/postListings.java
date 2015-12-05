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
@WebServlet(name = "postListings", urlPatterns = {"/postListings"})
public class postListings extends HttpServlet {

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
                        "    </head>\n" +
                        "<body>";
        return header;
    }

    protected String getLargeQuestion(String name, String pic, String question, 
                                      String topic, String date) {
        String title =  "<h1>" +
                        question +
                        "</h1>" +
                        "<h3><img src=" +
                        pic + 
                        " />\n" +
                        name +
                        "</h3>\n Topic: " +
                        topic +
                        " <br/>Posted: " +
                        date +
                        "</h3>\n<br/>\n<br/>\n";
        return title;
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

    protected String getResponse(String name, String pic, String reply, String date){
            String content =    "            <li><h3>" +                                        
                                name + 
                                "                </h3><div class=\"commenterImage\">\n" +
                                "                  <img src=" + 
                                pic +
                                "                   />" +
                                "                </div>\n" +
                                "                <div class=\"commentText\">\n" +
                                "                    <p>" + 
                                reply + 
                                "               </p> <span class=\"date sub-text\">on " +
                                date + 
                                "               </span>\n" +
                                "                \n" +
                                "                </div>\n" +
                                "            </li>";
            return content;
    }
        
    protected String getEndNewBox(){
            String endBox = "        <form class=\"form-inline\" role=\"form\">\n" +
                            "            <div class=\"form-group\">\n" +
                            "                <input class=\"form-control\" type=\"text\" placeholder=\"Your comments\" />\n" +
                            "            </div>            \n" +
                            "            <div class=\"form-group\">\n" +
                            "                <button class=\"btn btn-default\">Add</button>\n" +
                            "            </div>\n" +
                            "        </form>";
            return endBox;
    }

    protected String getEndHTML(){
            String end = "</body>\n</html>";
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
        
        String desiredTopic;
        desiredTopic= request.getParameter("topic");
 
        // Error checking; We hope this becomes 'true'
        Boolean foundMatch = false;

        Vector<Integer> posterIDs = new Vector<>();        
        Vector<String> title = new Vector<>();        
        Vector<String> topics = new Vector<>();        
        Vector<String> author = new Vector<>();        
        Vector<String> authorPic = new Vector<>();        
        
        // Define our constants
        String DB_URL = "jdbc:mysql://localhost/jsp";
        String USER = "adminLGMn6AW";
        String PASS = "Lhh3jeWDXKe1";
        
        String relatedPosts = "<h2>Recent posts below</h2>";
        String posts = "";
        
        // Connect to our database
        Connection conn = null;
        Statement  stmt = null;
                
        Boolean topicDefined = false;
        
        String SQL_ALLPOSTS = "";        
        if(desiredTopic == null)
             SQL_ALLPOSTS = "SELECT * FROM posts JOIN users ON posts.user_id=users.user_id";
        else {
            topicDefined = true;
            SQL_ALLPOSTS = "SELECT * FROM posts JOIN users ON posts.user_id=users.user_id AND posts.topic=\"" + desiredTopic + "\"";
        }
                
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Loads a class in by a dynamic string's name vs static naming convetntions    
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Get the Post's information
            rs = stmt.executeQuery(SQL_ALLPOSTS);
            while(rs.next()) {
                foundMatch = true;
                posterIDs.add(rs.getInt("post_id"));
                title.add(rs.getString("title"));
                topics.add(rs.getString("topic"));
                author.add(rs.getString("name"));
                authorPic.add(rs.getString("pic"));
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
        
        // If the post idh has no matches then send us to an appropriate page
        if(foundMatch == false) {
            response.sendRedirect("https://www.lds.org/scriptures/bd/faith");
            return;
        }
            

        //     protected String getResponse(String name, String pic, String reply, String date){                
//        try (PrintWriter out = response.getWriter()) {
//
//            out.println(getHeaderInfo());

                // "<div class=\"commenterImage\">\n" + " <img src=" + pic + "/>"
            if(topicDefined) {
                relatedPosts = "<h2>Posts relating to " + desiredTopic + "</h2>";
            }
                
            for(int i = 0; i < posterIDs.size(); i++) {
                posts += "<a href = forumRequest?entry=" + posterIDs.get(i) + ">" + title.get(i) + "</a><br/>" +
                        "<div class=\"commenterImage\">\n" + " <img src=" + authorPic.get(i) + "></div>" +
                        "posted by: " + author.get(i) + " " +
                        "regarding " + "<a href=postListings?topic=" + topics.get(i) + ">" + topics.get(i) + "</a>" +
                        "<br><br>";

                /*
                posterIDs.add(rs.getInt("post_id"));
                title.add(rs.getString("title"));
                topics.add(rs.getString("topic"));
                author.add(rs.getString("name"));
                 */
                
            }
            
            request.getSession().setAttribute("posts", posts);
            request.getSession().setAttribute("relatedPosts", relatedPosts);
            
            request.getRequestDispatcher("/postListings.jsp").forward(request, response);
//            out.println(getEndHTML());
//        }
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
