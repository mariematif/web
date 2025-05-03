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
@WebServlet("/StatistiquesServlet")
public class StatistiquesServlet extends HttpServlet {
    private final TacheDao tacheDao = new TacheDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int todo = 0, encours = 0, termine = 0;

        for (Tache t : tacheDao.findAll()) {
            switch (t.getEtat()) {
                case "To Do": todo++; break;
                case "En cours": encours++; break;
                case "Terminé": termine++; break;
            }
        }

        String json = String.format("{\"todo\":%d, \"encours\":%d, \"termine\":%d}", todo, encours, termine);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}

