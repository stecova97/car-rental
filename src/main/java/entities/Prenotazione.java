package main.java.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "data_inizio" , nullable = false)
    private Date data_inizio;

    @Column(name = "data_fine", nullable = false)
    private Date data_fine;

    @OneToOne
    private int utente;

    @OneToOne(mappedBy = "targa")
    private String veicolo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_fine() {
        return data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
    }

    public int getUtente() {
        return utente;
    }

    public void setUtente(int utente) {
        this.utente = utente;
    }

    public String getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(String veicolo) {
        this.veicolo = veicolo;
    }
}
