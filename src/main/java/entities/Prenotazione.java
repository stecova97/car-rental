package main.java.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {

    @Id
    @Column(name = "id_prenotazione", nullable = false)
    private int idPrenotazione;

    @Column(name = "data_inizio" , nullable = false)
    private Date data_inizio;

    @Column(name = "data_fine", nullable = false)
    private Date data_fine;

    @ManyToOne
    @JoinColumn(name="veicolo", nullable = false)
    private Veicolo veicolo;

    @ManyToOne
    @JoinColumn(name="utente", nullable = false)
    private Utente utente;

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
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

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
