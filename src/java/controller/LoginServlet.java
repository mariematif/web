package controller;

import entities.User;
import service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        // ✅ Validation de l'email
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            request.setAttribute("error", "Adresse email invalide !");
            request.getRequestDispatcher("login.jsp?type=" + type).forward(request, response);
            return;
        }

        // ✅ Validation du mot de passe
        if (password == null || password.length() < 5) {
            request.setAttribute("error", "Mot de passe trop court (min 5 caractères) !");
            request.getRequestDispatcher("login.jsp?type=" + type).forward(request, response);
            return;
        }

        // ✅ Authentification via service
        User user = userService.login(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // ✅ Redirection selon le type
            if ("admin".equalsIgnoreCase(type)) {
                response.sendRedirect("admin/dashboard.jsp");
            } else if ("collaborateur".equalsIgnoreCase(type)) {
                response.sendRedirect("collaborateur/dashboard.jsp");
            } else {
                response.sendRedirect("home.jsp");
            }
        } else {
            request.setAttribute("error", "Email ou mot de passe incorrect !");
            request.getRequestDispatcher("login.jsp?type=" + type).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet de connexion avec validation";
    }
}
