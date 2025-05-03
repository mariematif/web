
  package controller;

import dao2.CategorieTacheDao;
import dao2.CollaborateurDao;
import dao2.ProjetDao;
import dao2.TacheDao;
import entities.CategorieTache;
import entities.Collaborateur;
import entities.Projet;
import entities.Tache;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


  @WebServlet(name = "TachesServlet", urlPatterns = {"/TachesServlet"})

public class TachesServlet extends HttpServlet {


private final TacheDao tacheDao = new TacheDao();
private final ProjetDao projetDao = new ProjetDao();
private final CategorieTacheDao categorieDao = new CategorieTacheDao();
private final CollaborateurDao collaborateurDao = new CollaborateurDao();

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String op = request.getParameter("op");

    if (op != null && op.equals("delete")) {
        int id = Integer.parseInt(request.getParameter("id"));
        Tache t = tacheDao.findById(id);
        tacheDao.delete(t);
       response.sendRedirect(request.getContextPath() + "/TachesServlet");

        return;
    }

    if (op != null && op.equals("edit")) {
        int id = Integer.parseInt(request.getParameter("id"));
        Tache tache = tacheDao.findById(id);
        request.setAttribute("tacheToEdit", tache);
    }

    chargerDonnees(request);
  
    request.getRequestDispatcher("admin/taches.jsp").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.parseInt(request.getParameter("id")) : 0;
    String titre = request.getParameter("titre");
    String description = request.getParameter("description");
    String etat = request.getParameter("etat");
    int projetId = Integer.parseInt(request.getParameter("projetId"));
    int categorieId = Integer.parseInt(request.getParameter("categorieId"));
    int collaborateurId = Integer.parseInt(request.getParameter("collaborateurId"));

    Projet projet = projetDao.findById(projetId);
    CategorieTache categorie = categorieDao.findById(categorieId);
    Collaborateur collaborateur = collaborateurDao.findById(collaborateurId);

    Tache tache;
    if (id > 0) {
        tache = tacheDao.findById(id);
        tache.setTitre(titre);
        tache.setDescription(description);
        tache.setEtat(etat);
        tache.setProjet(projet);
        tache.setCategorie(categorie);
        tache.setCollaborateur(collaborateur);
        tacheDao.update(tache);
    } else {
        tache = new Tache(titre, description, etat, projet, categorie, collaborateur);
        tacheDao.create(tache);
    }

   response.sendRedirect("TachesServlet");

}

private void chargerDonnees(HttpServletRequest request) {
    List<Tache> taches = tacheDao.findAll();
    List<Projet> projets = projetDao.findAll();
    List<CategorieTache> categories = categorieDao.findAll();
    List<Collaborateur> collaborateurs = collaborateurDao.findAll();

    request.setAttribute("taches", taches);
    request.setAttribute("projets", projets);
    request.setAttribute("categories", categories);
    request.setAttribute("collaborateurs", collaborateurs);
}


}




