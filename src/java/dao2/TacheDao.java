/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import java.util.List;
import entities.Tache;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Hp
 */
public class TacheDao extends AbstractDao<Tache> {

    public TacheDao() {
        super(Tache.class);
    }

   
   
    @SuppressWarnings("unchecked")
   
public List<Tache> findByCollaborateurId(int collaborateurId) {
    Session session = null;
    Transaction tx = null;
    List<Tache> liste = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String hql = "FROM Tache WHERE collaborateur.id = :id";
        liste = session.createQuery(hql)
                       .setParameter("id", collaborateurId)
                       .list();

        tx.commit();
    } catch (Exception e) {
        if (tx != null) tx.rollback();
    } finally {
        if (session != null) session.close();
    }

    return liste;
}

   


}
