package dao;

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import util.HibernateUtil;

import java.util.List;

public class UserDao {

    // ✅ Créer un utilisateur
    public boolean create(User o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.save(o);

            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return etat;
    }

    // ✅ Connexion d'un utilisateur par email + mot de passe
    public User connecter(String email, String password) {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String hql = "FROM User u WHERE u.email = :email AND u.motDePasse = :password";
            @SuppressWarnings("unchecked")
List<User> result = session.createQuery(hql)
    .setParameter("email", email)
    .setParameter("password", password)
    .list();


            if (!result.isEmpty()) {
                user = result.get(0); // retourne le premier trouvé
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return user;
    }
}
