package controller;

import dao2.ProjetDao;
import entities.Projet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProjetServlet", urlPatterns = {"/ProjetServlet"})
public class ProjetServlet extends HttpServlet {

    private final ProjetDao projetDao = new ProjetDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        if (op != null) {
            if (op.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Projet projet = projetDao.findById(id);
                request.setAttribute("projet", projet);
            } else if (op.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Projet projet = projetDao.findById(id);
                if (projet != null) {
                    projetDao.delete(projet);
                }
                response.sendRedirect("ProjetServlet"); 

                return; 
            }
        }

        List<Projet> projets = projetDao.findAll();
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("admin/projets.jsp").forward(request, response);
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String idStr = request.getParameter("id");
    String nom = request.getParameter("nom");
    String description = request.getParameter("description");

    if (idStr != null && !idStr.isEmpty()) {
        int id = Integer.parseInt(idStr);
        Projet projet = projetDao.findById(id);
        if (projet != null) {
            projet.setNom(nom);
            projet.setDescription(description);
            projetDao.update(projet);
        }
    } else {
        Projet projet = new Projet(nom, description);
        projetDao.create(projet);
    }

    // ✅ Redirection correcte après insertion ou modification
    response.sendRedirect("ProjetServlet");
}

}
