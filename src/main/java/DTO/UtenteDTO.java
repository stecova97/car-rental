package main.java.DTO;
import main.java.entities.Utente;
import main.java.entities.Ruolo;


public class UtenteDTO {

    private String email;
    private String psw;


    public UtenteDTO(int id, String email, String psw, Ruolo ruolo) {
        this.email = email;
        this.psw = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
