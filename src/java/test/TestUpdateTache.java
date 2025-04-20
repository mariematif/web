package test;

import dao2.TacheDao;
import entities.Tache;

public class TestUpdateTache {
    public static void main(String[] args) {
        TacheDao dao = new TacheDao();
        Tache t = dao.findById(1); // à adapter selon les IDs dans ta BD

        if (t != null) {
            t.setEtat("Terminé");
            t.setTitre("DAO modifié");
            dao.update(t);
            System.out.println("🔁 Tâche modifiée !");
        } else {
            System.out.println("❌ Tâche introuvable !");
        }
    }
}
