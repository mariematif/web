package controller;

import dao2.CollaborateurDao;
import entities.Collaborateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CollaborateurServlet", urlPatterns = {"/CollaborateurServlet"})
public class CollaborateurServlet extends HttpServlet {

    private final CollaborateurDao collaborateurDao = new CollaborateurDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        if (op != null) {
            if (op.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Collaborateur c = collaborateurDao.findById(id);
                if (c != null) {
                    collaborateurDao.delete(c);
                }
                 response.sendRedirect("CollaborateurServlet");
return;

            } else if (op.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Collaborateur c = collaborateurDao.findById(id);
                request.setAttribute("collaborateurToEdit", c);
            }
        }

        List<Collaborateur> collaborateurs = collaborateurDao.findAll();
        request.setAttribute("collaborateurs", collaborateurs);
    
        request.getRequestDispatcher("admin/collaborateurs.jsp").forward(request, response);

    }

    @Override

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String idStr = request.getParameter("id");
    String nom = request.getParameter("nom");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (idStr != null && !idStr.isEmpty()) {
        // update
    } else {
        // création
        Collaborateur c = new Collaborateur(nom, email, password);
        collaborateurDao.create(c);
    }

    response.sendRedirect("CollaborateurServlet");
}

    
}
