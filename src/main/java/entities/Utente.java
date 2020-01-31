package main.java.entities;

import javax.persistence.*;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    private int

}
