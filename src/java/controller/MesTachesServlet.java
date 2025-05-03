package controller;

import dao2.TacheDao;
import entities.Collaborateur;
import entities.Tache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MesTachesServlet", urlPatterns = {"/CollaborateurMesTaches"})
public class MesTachesServlet extends HttpServlet {

    private final TacheDao tacheDao = new TacheDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // ❗ false : évite de créer une session vide

        // ✅ Vérifie que l'utilisateur est bien connecté
        if (session == null || session.getAttribute("user") == null || !(session.getAttribute("user") instanceof Collaborateur)) {
            response.sendRedirect("login.jsp");
            return;
        }

        // ✅ Récupérer l'utilisateur connecté
        Collaborateur collaborateur = (Collaborateur) session.getAttribute("user");

        // ✅ Récupérer les tâches associées à ce collaborateur
        List<Tache> mesTaches = tacheDao.findByCollaborateurId(collaborateur.getId());

        // ✅ Injecter dans la vue
        request.setAttribute("mesTaches", mesTaches);
        request.getRequestDispatcher("/collaborateur/mesTaches.jsp").forward(request, response);
    }
}
