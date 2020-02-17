package main.java.DAO;

import main.java.entities.Prenotazione;
import main.java.entities.Utente;

import java.util.List;

public interface PrenotazioneDAO {
    //utilizzo DTO?
    void salvaPrenotazione (Prenotazione p);
    //void updatePrenotazione (Prenotazione p);
    List<Prenotazione> selezionaPrenotazioniPerUtente(Integer id);
    void eliminaPrenotazione (Prenotazione p);
    Prenotazione selezionaPrenotazione(int id);

}
