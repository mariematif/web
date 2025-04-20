package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity

public class Collaborateur extends User  {



    public Collaborateur() {
          super();
    }
    @OneToMany(mappedBy = "collaborateur")
private List<Tache> taches;


    public Collaborateur(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

}
