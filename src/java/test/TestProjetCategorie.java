package test;

import dao2.ProjetDao;
import dao2.CategorieTacheDao;
import entities.Projet;
import entities.CategorieTache;

public class TestProjetCategorie {
    public static void main(String[] args) {
        ProjetDao projetDao = new ProjetDao();
        CategorieTacheDao categorieDao = new CategorieTacheDao();

        projetDao.create(new Projet("Suivi étudiants", "Projet académique"));
        projetDao.create(new Projet("RH", "Système RH"));

        categorieDao.create(new CategorieTache("Design"));
        categorieDao.create(new CategorieTache("Testing"));

        System.out.println("✅ Projets et catégories ajoutés !");
    }
}
