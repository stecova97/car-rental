package main.java.DAO;

import main.java.DTO.UtenteDTO;
import main.java.entities.Utente;

import java.util.List;

public interface UtenteDAO {
    Utente loginUtente(UtenteDTO utenteDTO);
    void eliminaUtente(Integer id);
    void updateUtente(Utente u);
    void salvaUtente(Utente u);
    List<Utente> selezionaUtenti();
    Utente trovaUtente(String email);
}
