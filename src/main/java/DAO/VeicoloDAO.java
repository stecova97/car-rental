package main.java.DAO;

import main.java.entities.Veicolo;

import java.util.List;

public interface VeicoloDAO {
    Veicolo selezioneVeicolo (String cod);
    List<Veicolo>  elencoVeicoli();
    void eliminaVeicolo(String cod);
    void salvaVeicolo(Veicolo v);

}
