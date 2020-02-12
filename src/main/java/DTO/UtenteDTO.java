package main.java.DTO;
import main.java.entities.Utente;
import main.java.entities.Ruolo;


public class UtenteDTO {

    private String email;
    private String psw;


    public UtenteDTO(String email, String psw) {
        this.email = email;
        this.psw = psw;
    }

    public UtenteDTO() {

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

    @Override
    public String toString() {
        return "UtenteDTO{" +
                "email='" + email + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
