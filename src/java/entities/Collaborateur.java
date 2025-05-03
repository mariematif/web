package entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "collaborateurs")
@PrimaryKeyJoinColumn(name = "id") 
public class Collaborateur extends User {


   

    public Collaborateur() {
        super();
    }

   
  public Collaborateur(String nom, String email, String mdp) {
        super(nom, email, mdp);
       
    }
}
