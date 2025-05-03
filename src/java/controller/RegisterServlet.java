/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao2.UserDao;
import entities.Admin;
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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private final UserDao userDao = new UserDao(); // utilise AdminDao si tu en as un

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String motDePasse = req.getParameter("motDePasse");

        Admin admin = new Admin(nom, email, motDePasse);
        userDao.create(admin);

        req.getSession().setAttribute("user", admin);
        resp.sendRedirect("admin/dashboard.jsp");     
    }
}

