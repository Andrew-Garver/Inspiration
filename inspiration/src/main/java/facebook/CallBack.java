/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import facebook4j.Facebook; 
import facebook4j.FacebookException;
import facebook4j.IdNameEntity;
import facebook4j.PictureSize;
import java.net.URL;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew Garver
 */
@WebServlet(name = "CallBack", urlPatterns = {"/CallBack"})
public class CallBack extends HttpServlet {

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
            out.println("<title>Servlet CallBack</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CallBack at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession(true);
        request.getSession().setAttribute("loggedIn", true);

        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");

        String oauthCode = request.getParameter("code");

        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException e) {
            e.printStackTrace();
        }
        
        try {
            request.getSession().setAttribute("name", facebook.getName());
            String name = facebook.getName();
            request.getSession().setAttribute("id", facebook.getId());
            request.getSession().setAttribute("profilePic", facebook.getPictureURL(PictureSize.large));
            URL pic = facebook.getPictureURL();
            request.getSession().setAttribute("birthday", facebook.getMe().getBirthday());
            String birthday = facebook.getMe().getBirthday();
            request.getSession().setAttribute("bio", facebook.getMe().getBio());
            String desc = facebook.getMe().getBio();
            request.getSession().setAttribute("homeTown", facebook.getMe().getHometown());
            IdNameEntity loc = facebook.getMe().getHometown();
            request.getSession().setAttribute("education", facebook.getMe().getEducation());
            request.getSession().setAttribute("country", facebook.getMe().getLocale());
            request.getSession().setAttribute("work", facebook.getMe().getWork());
            request.getSession().setAttribute("website", facebook.getMe().getWebsite());
            URL website = facebook.getMe().getWebsite();
            
            String sql = "INSERT INTO users(name, desc, pic, birth_date, location, personal_site, join_date) "
                + "VALUES('" + name + "','" + desc + "','" + pic + "','" + birthday + "','" + loc + "','"
                + website + "','" + new Date() + "')";
        
            dbConnection db = new dbConnection();
            db.insertOrDeleteQuery(sql);
            
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (FacebookException e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("homepage.jsp");

        //processRequest(request, response);
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
