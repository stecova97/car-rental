package main.java.DAO;

import main.java.entities.Prenotazione;
import main.java.entities.Utente;

import java.util.List;

public interface PrenotazioneDAO {
    //utilizzo DTO?
    void salvaPrenotazione (Prenotazione p);
    List<Prenotazione> selezionaPrenotazioniPerUtente(String email);
    void eliminaUtente (Utente utente);
    Prenotazione selezionaPrenotazione(int id);

}
