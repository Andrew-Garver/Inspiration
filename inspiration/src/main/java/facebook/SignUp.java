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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew Garver
 */
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

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
            out.println("<title>Servlet SignUp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUp at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String website = "http://gothamist.com/2015/09/21/youd_be_surprised_why_you_need_a_pe.php";
        if(!request.getParameter("website").equals("")) {
            website = request.getParameter("website");
        }
        String linkedin = "https://www.linkedin.com/";
        if(!request.getParameter("linkedin").equals("")) {
            linkedin = request.getParameter("linkedin");
        }
        String picurl = "http://www.visimpact.net/wp-content/uploads/2014/11/no_user_icon.gif";
        if(!request.getParameter("picurl").equals("")) {
            picurl = request.getParameter("picurl");
        }
        String username = request.getParameter("username");
        String birthday = request.getParameter("birthday");
        String location = request.getParameter("location");
        String password = request.getParameter("password");
        String description = request.getParameter("description");
        
        String checkIfUserExists = "SELECT * FROM users WHERE email = '" + email + "' OR username = '" + username + "'";
        String insertUserIntoTable = "INSERT INTO users (username,email,password,name,user_desc,pic,birth_date,location,linked_in,personal_site)"
                + " VALUES ('" + username + "','" + email + "','" + password + "','"+name+"','" + description.replaceAll("'", "&#39;") + "','" + picurl + "','" + birthday + "','" + location + "','" + linkedin + "','" + website + "')";
        String getUserId = "SELECT user_id FROM users WHERE username = '" + username + "'";
        
        dbConnection db = new dbConnection();
        db.setConnections();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs;
        try {
            Class.forName(db.getJDBC_DRIVER());
            conn = DriverManager.getConnection(db.getDB_URL(), db.getUSER(), db.getPASS());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(checkIfUserExists);
            if (rs.next()) { // if the user already exists, handle it
                request.getSession().setAttribute("dupeAcct", "That username or email has already been registered");
                response.sendRedirect("signUp.jsp");
            } else { // input the user to the db
                stmt = conn.createStatement();
                stmt.executeUpdate(insertUserIntoTable);
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            out.println("Could not connect to db");
            se.printStackTrace();
        } catch (Exception se) {
            out.println("exception thrown std");
            request.getSession().setAttribute("badLogin", "Getting an exception when trying to log in...");
            response.sendRedirect("signIn.jsp");
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        // add any other info we might need here
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", password);
        // calls the logIn servlet to handle logIn procedures using the username and password just created
        RequestDispatcher rd = request.getRequestDispatcher("logIn");
        rd.forward(request, response);
        
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
