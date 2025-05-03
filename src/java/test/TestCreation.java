package test;

import dao2.*;
import entities.*;

public class TestCreation {

    public static void main(String[] args) {
        ProjetDao projetDao = new ProjetDao();
        CategorieTacheDao categorieDao = new CategorieTacheDao();
        TacheDao tacheDao = new TacheDao();
        CollaborateurDao collaborateurDao = new CollaborateurDao();
        UserDao userDao = new UserDao(); // ✅ Ajouté pour créer un admin

        // ✅ Création d’un projet
        Projet projet = new Projet("Gestion des tâches", "Application de suivi de projet collaboratif");
        projetDao.create(projet);

        // ✅ Création d’une catégorie
        CategorieTache categorie = new CategorieTache("Conception");
        categorieDao.create(categorie);

        // ✅ Création d’un administrateur
        Admin admin = new Admin("MrZahid", "admin1@example.com", "admin123");
        userDao.create(admin); // correction de variable

        // ✅ Création d’un collaborateur
        Collaborateur collaborateur = new Collaborateur("Zineb", "zineb@projet.com", "12345");
        collaborateurDao.create(collaborateur);

        // ✅ Création d’une tâche
        Tache tache = new Tache("Créer l'entité Tache", "Définir la classe + mapping JPA", "To Do", projet, categorie, collaborateur);
        tacheDao.create(tache);

        // ✅ Vérification
        Tache t = tacheDao.findById(tache.getId());
        Projet p = projetDao.findById(projet.getId());
        CategorieTache c = categorieDao.findById(categorie.getId());
        Collaborateur co = collaborateurDao.findById(collaborateur.getId());

        // ✅ Affichage
        System.out.println("✅ Données insérées avec succès !");
        System.out.println("📝 Tâche : " + t.getTitre() + " | Etat : " + t.getEtat());
        System.out.println("📁 Projet : " + p.getNom());
        System.out.println("📂 Catégorie : " + c.getNom());
        System.out.println("👤 Collaborateur : " + co.getNom() + " | Email : " + co.getEmail());
        System.out.println("👨‍💼 Admin : " + admin.getNom() + " | Email : " + admin.getEmail());
    }
}
