/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "tache")

public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private String etat;

    @ManyToOne
   @JoinColumn(name = "projet_id", referencedColumnName = "id")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "id")
    private CategorieTache categorie;

    @ManyToOne
    @JoinColumn(name = "collaborateur_id", referencedColumnName = "id")

    private Collaborateur collaborateur;

    public Tache() {
    }

    public Tache(String titre, String description, String etat, Projet projet, CategorieTache categorie, Collaborateur collaborateur) {
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.projet = projet;
        this.categorie = categorie;
        this.collaborateur = collaborateur;

    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public CategorieTache getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieTache categorie) {
        this.categorie = categorie;
    }

    public Collaborateur getCollaborateur() {

        return collaborateur;

    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

}
