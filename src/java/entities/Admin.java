package entities;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "admins")
public class Admin extends User {

    public Admin() {
        
    }

    public Admin(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
       
    }
}
