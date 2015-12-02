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
        
    protected String getEndNewBox(String id){
            String endBox = "        <form action=\"PostComment\" method=\"post\" class=\"form-inline\" role=\"form\">\n" +
                            "            <div class=\"form-group\">\n" +
                            "               <input type=\"hidden\" name=\"question_id\" value=\"" +
                            id + 
                            "\">" +
                            "                <input class=\"form-control\" name=\"reply\" type=\"text\" placeholder=\"Your comments\" />\n" +
                            "            </div>            \n" +
                            "            <div class=\"form-group\">\n" +
                            "                <input type=\"submit\" value=\"Add\" class=\"btn btn-default\">\n" +
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
        
        String getID = request.getParameter("entry");
 
        // Error checking; We hope this becomes 'true'
        Boolean foundMatch = false;

        Integer posterID = -1;
        String author = "UNDEFINED";
        String title = "UNDEFINED";
        String topic = "UNDEFINED";
        String pic = "UNDEFINED";
        String joinDate = "UNDEFINED";
        
        Vector<Integer> responderIDs = new Vector<>();        
        Vector<String> names = new Vector<>();        
        Vector<String> photoURLs = new Vector<>();        
        Vector<String> content = new Vector<>();        
        Vector<String> time = new Vector<>();        
        
        // Define our constants
        String DB_URL = "jdbc:mysql://localhost/jsp";
        String USER = "adminLGMn6AW";
        String PASS = "Lhh3jeWDXKe1";
        
        // Connect to our database
        Connection conn = null;
        Statement  stmt = null;
        String SQL_POST = "SELECT * FROM posts JOIN users ON posts.post_id = " + getID + " AND posts.user_id=users.user_id";
        String SQL_COMMENTS = "SELECT * FROM replies JOIN users ON replies.post_id=" + getID + " AND replies.user_id=users.user_id";
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver"); // Loads a class in by a dynamic string's name vs static naming conventions    
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Get the Post's information
            rs = stmt.executeQuery(SQL_POST);
            while(rs.next()) {
                // Grab variables & store them
                foundMatch = true;
                posterID = rs.getInt("post_id");
                author = rs.getString("name");
                title = rs.getString("title");
                topic = rs.getString("topic");
                pic = rs.getString("pic");
                joinDate = (rs.getDate("date_posted")).toString();
            }
            
            // Get the Reply information
            rs = stmt.executeQuery(SQL_COMMENTS);
            while(rs.next()) {
                // Grab variables & store them
                responderIDs.add(rs.getInt("user_id"));
                names.add(rs.getString("name"));
                photoURLs.add(rs.getString("pic"));
                content.add(rs.getString("content"));
                time.add((rs.getDate("date_posted")).toString());
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
            response.sendRedirect("https://www.lds.org/scriptures/bd/repentance");
            return;
        }
            
        //     protected String getResponse(String name, String pic, String reply, String date){                
        try (PrintWriter out = response.getWriter()) {

            out.println(getHeaderInfo());
            out.println(getLargeQuestion(author, pic, title, topic, joinDate));
            out.println(getNewBox());

            if(content.size() == 0)
                out.println("<h2>No replies have been posted to this question</h2>");
            for(int i = 0; i < content.size(); i++) 
                out.println(getResponse(names.get(i), photoURLs.get(i), content.get(i), time.get(i)));                

            out.println(getEndNewBox(getID));
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
