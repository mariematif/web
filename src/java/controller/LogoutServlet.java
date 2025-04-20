package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false); // récupérer la session s’il y en a une
        if (session != null) {
            session.invalidate(); // détruire la session
        }
        
        response.sendRedirect("home.jsp"); // retour à la page d’accueil
    }

    @Override
    public String getServletInfo() {
        return "Servlet de déconnexion";
    }
}
