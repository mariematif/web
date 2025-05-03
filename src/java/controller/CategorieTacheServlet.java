/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao2.CategorieTacheDao;
import entities.CategorieTache;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(name = "CategorieTacheServlet", urlPatterns = {"/CategorieTacheServlet"})

public class CategorieTacheServlet extends HttpServlet {

    private final CategorieTacheDao categorieDao = new CategorieTacheDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        if (op != null && op.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            CategorieTache c = categorieDao.findById(id);
            if (c != null) {
                categorieDao.delete(c);
            }
            response.sendRedirect("CategorieTacheServlet"); // ✅ correction ici
            return;
        }

        if (op != null && op.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            CategorieTache categorieToEdit = categorieDao.findById(id);
            request.setAttribute("categorieToEdit", categorieToEdit);
        }

        List<CategorieTache> categories = categorieDao.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("admin/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String idStr = request.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            CategorieTache cat = categorieDao.findById(id);
            if (cat != null) {
                cat.setNom(nom);
                categorieDao.update(cat);
            }
        } else {
            CategorieTache categorie = new CategorieTache(nom);
            categorieDao.create(categorie);
        }

        response.sendRedirect("CategorieTacheServlet"); 
    }
}
