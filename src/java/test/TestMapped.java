package test;

import dao2.TacheDao;
import entities.Tache;
import entities.Projet;
import entities.CategorieTache;
import entities.Collaborateur;

public class TestMapped {
    public static void main(String[] args) {
        TacheDao dao = new TacheDao();
        Tache tache = dao.findById(1); // ID à adapter

        if (tache != null) {
            Projet projet = tache.getProjet();
            CategorieTache categorie = tache.getCategorie();
            Collaborateur collaborateur = tache.getCollaborateur();

            System.out.println("🔎 Vérification Mapping JPA :");
            System.out.println("Titre        : " + tache.getTitre());
            System.out.println("Projet       : " + (projet != null ? projet.getNom() : "null"));
            System.out.println("Catégorie    : " + (categorie != null ? categorie.getNom() : "null"));
            System.out.println("Collaborateur: " + (collaborateur != null ? collaborateur.getNom() : "null"));
        } else {
            System.out.println("❌ Tâche non trouvée !");
        }
    }
}
