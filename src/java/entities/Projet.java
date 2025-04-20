package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projets")
public class Projet  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   int id;

    private String nom;
    private String description;

   
@OneToMany(mappedBy = "projet")
private List<Tache> taches;


    // Constructeurs, getters, setters
    public Projet() {
    }

    public Projet(String nom, String description) {
        this.nom = nom;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }
}
