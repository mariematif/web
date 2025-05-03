/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao2.TacheDao;
import entities.Tache;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(name = "ChangerEtatTacheServlet", urlPatterns = {"/ChangerEtatTacheServlet"})

public class ChangerEtatTacheServlet extends HttpServlet {
    private final TacheDao tacheDao = new TacheDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int tacheId = Integer.parseInt(request.getParameter("tacheId"));
        String nouvelEtat = request.getParameter("etat");

        Tache tache = tacheDao.findById(tacheId);
        if (tache != null) {
            tache.setEtat(nouvelEtat);
            tacheDao.update(tache);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

