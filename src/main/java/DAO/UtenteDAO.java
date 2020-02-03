package main.java.DAO;

import main.java.entities.Utente;

public interface UtenteDAO {
    Utente loginUtente(String email, String psw);
    void eliminaUtente(String email);
    void updateUtente(Utente utente);
    Utente trovaUtente(int id);
}
