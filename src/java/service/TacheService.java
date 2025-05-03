package service;

import dao2.TacheDao;
import entities.Tache;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class TacheService implements IService<Tache> {

    private final TacheDao tacheDao = new TacheDao();

    // ✅ Ajouter une tâche
    @Override
    public boolean create(Tache t) {
        return tacheDao.create(t);
    }

    // ✅ Supprimer une tâche
    @Override
    public boolean delete(Tache t) {
        return tacheDao.delete(t);
    }

    // ✅ Modifier une tâche
    @Override
    public boolean update(Tache t) {
        return tacheDao.update(t);
    }

    // ✅ Lister toutes les tâches
    @Override
    public List<Tache> findAll() {
        return tacheDao.findAll();
    }

    // ✅ Trouver une tâche par ID
    @Override
    public Tache findById(int id) {
        return tacheDao.findById(id);
    }

  public List<Tache> findByCollaborateurId(int userId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Tache> result = null;
    try {
       Query query = session.createQuery("FROM Tache t WHERE t.collaborateur.id = :id");

        query.setParameter("id", userId);
        result = query.list();
    } catch (Exception e) {
    } finally {
        session.close();
    }
    return result;
}


}
