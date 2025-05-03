package service;

import dao2.CollaborateurDao;
import entities.Collaborateur;
import java.util.List;

public class CollaborateurService implements IService<Collaborateur> {

    private final CollaborateurDao collaborateurDao;

    public CollaborateurService() {
        this.collaborateurDao = new CollaborateurDao();
    }

    @Override
    public boolean create(Collaborateur o) {
        return collaborateurDao.create(o);
    }

    @Override
    public boolean update(Collaborateur o) {
        return collaborateurDao.update(o);
    }

    @Override
    public boolean delete(Collaborateur o) {
        return collaborateurDao.delete(o);
    }

    @Override
    public List<Collaborateur> findAll() {
        return collaborateurDao.findAll();
    }

    @Override
    public Collaborateur findById(int id) {
        return collaborateurDao.findById(id);
    }

    public List<Collaborateur> findByNom(String nom) {
        return collaborateurDao.findByNom(nom);
    }
}
