package test;

import dao2.TacheDao;
import entities.Tache;

public class TestDeleteTache {
    public static void main(String[] args) {
        TacheDao dao = new TacheDao();
        Tache t = dao.findById(1); // à adapter

        if (t != null) {
            dao.delete(t);
            System.out.println(" Tâche supprimée !");
        } else {
            System.out.println(" Tâche non trouvée !");
        }
    }
}
