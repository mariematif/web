/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author Hp
 */
@Entity
@Table(name = "admins")
public class Admin extends User {

public Admin() {
        super();
}

    public Admin( String nom, String email, String motDePasse) {
      super(nom, email, motDePasse);

}}