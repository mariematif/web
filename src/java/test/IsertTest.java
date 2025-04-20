package test; // change si ton package est différent

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class IsertTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Création des utilisateurs
            User u1 = new User("Admin", "admin@admin.com", "admin123");
            User u2 = new User("Collaborateur", "collab@projet.com", "collab123");

            // Insertion dans la base de données
            session.save(u1);
            session.save(u2);

            tx.commit();
            System.out.println("Utilisateurs insérés avec succès !");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
