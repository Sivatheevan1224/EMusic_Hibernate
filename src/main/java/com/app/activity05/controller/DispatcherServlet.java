package com.app.activity05.controller;

import com.app.activity05.entity.Album;
import com.app.activity05.entity.User;
import com.app.activity05.service.AlbumDAO;
import com.app.activity05.service.UserDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "DispatcherServlet", urlPatterns = {"*.html"})
public class DispatcherServlet extends HttpServlet {
    UserDAO userdao = new UserDAO();
    AlbumDAO albumdao = new AlbumDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url= request.getServletPath();
        
        switch (url) {
            case "/home.html":
                loadHomePage(request, response);
                break;
            case "/login.html":
                userLogin(request, response);
                break;
            case "/album-list.html":
                loadAlbumListPage(request, response);
                break;
            case "/album-view.html":
                loadAlbumViewPage(request, response);
                break;
            case "/sign-in.html":
                logout(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private void getView(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + view + ".jsp");
        rd.forward(request, response);
    }
    
    private void loadHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        getView(request, response, "sign-in");
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user= userdao.authenticate(request.getParameter("username"),request.getParameter("password") );
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath()+"/album-list.html");
        }else{
            request.setAttribute("errMsg", "Incorrect Username  or Password");
            getView(request, response, "sign-in");
        }   
    }
    
    private void loadAlbumListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Album> albumlist = albumdao.getAllAlbums();
        request.setAttribute("albumlist", albumlist);
        getView(request, response, "album-list");
    }
    
    private void loadAlbumViewPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int selectedAlbumId= Integer.parseInt(request.getParameter("id"));
        Album album = albumdao.getAlbumById(selectedAlbumId);
        request.setAttribute("album", album);
        getView(request, response, "album-view");
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session= request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/home.html");
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
