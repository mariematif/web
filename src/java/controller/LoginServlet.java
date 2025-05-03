package controller;

import entities.Admin;
import entities.Collaborateur;
import entities.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type"); // admin ou collaborateur

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Champs requis !");
            request.getRequestDispatcher("login.jsp?type=" + type).forward(request, response);
            return;
        }

        User user = userService.login(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("admin".equals(type) && user instanceof Admin) {
                response.sendRedirect("admin/dashboard.jsp");
            } else if ("collaborateur".equals(type) && user instanceof Collaborateur) {
                response.sendRedirect("collaborateur/dashboard.jsp");
            } else {
                request.setAttribute("error", "Type d'utilisateur incorrect !");
                request.getRequestDispatcher("login.jsp?type=" + type).forward(request, response);
            }

        } else {
            request.setAttribute("error", "Email ou mot de passe invalide !");
            request.getRequestDispatcher("login.jsp?type=" + type).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
