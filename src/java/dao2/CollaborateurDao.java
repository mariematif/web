/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Collaborateur;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Hp
 */
public class CollaborateurDao extends AbstractDao<Collaborateur> {

    public CollaborateurDao() {
        super(Collaborateur.class);
    }

   @SuppressWarnings("unchecked")
public List<Collaborateur> findByNom(String nom) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Collaborateur> collaborateurs = null;
    try {
        collaborateurs = session.createQuery("FROM Collaborateur WHERE nom = :nom")
                .setParameter("nom", nom)
                .list();
    } finally {
        session.close();
    }
    return collaborateurs;
}


    
}
