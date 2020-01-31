package main.java.entities;

import javax.persistence.*;

@Entity
@Table(name = "ruolo")
public class Ruolo {

    @Id
    @Column(name = "id" , nullable = false)
    private int id;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
