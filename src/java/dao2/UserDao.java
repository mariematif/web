package dao2;

import entities.User;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }

    @SuppressWarnings("unchecked")
    public User connecter(String email, String password) {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            List<User> result = session.createQuery(
                "FROM User WHERE email = :email AND motDePasse = :password")
                .setParameter("email", email)
                .setParameter("password", password)
                .list();

            if (!result.isEmpty()) {
                user = result.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }

        return user;
    }
}
