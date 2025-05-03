package controller;

import dao2.UserDao;
import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ModifierMotDePasseServlet", urlPatterns = {"/ModifierMotDePasseServlet"})
public class ModifierMotDePasseServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
        String confirmerMotDePasse = request.getParameter("confirmerMotDePasse");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (nouveauMotDePasse == null || confirmerMotDePasse == null || !nouveauMotDePasse.equals(confirmerMotDePasse)) {
            request.setAttribute("erreur", "❌ Les mots de passe ne correspondent pas.");
            request.getRequestDispatcher("collaborateur/profil.jsp").forward(request, response);
            return;
        }

        user.setMotDePasse(nouveauMotDePasse);
        boolean updated = userDao.update(user);

        if (updated) {
            request.setAttribute("message", "✅ Mot de passe mis à jour avec succès.");
        } else {
            request.setAttribute("erreur", "❌ Erreur lors de la mise à jour.");
        }

        request.getRequestDispatcher("collaborateur/profil.jsp").forward(request, response);
    }
}
