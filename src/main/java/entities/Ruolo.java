package main.java.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ruolo")
public class Ruolo {

    @Id
    @Column(name = "id_ruolo" , nullable = false)   //1 super 0 no
    private int idRuolo;

    @Column(name = "descrizione", nullable = false)
    private String descrizione;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utente> utente;

    public Ruolo() {
    }

    public int getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(int idRuolo) {
        this.idRuolo = idRuolo;
    }

    public List<Utente> getUtente() {
        return utente;
    }

    public void setUtente(List<Utente> utente) {
        this.utente = utente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
