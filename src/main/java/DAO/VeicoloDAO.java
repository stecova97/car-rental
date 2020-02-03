package main.java.DAO;

import main.java.entities.Veicolo;

import java.util.List;

public interface VeicoloDAO {
    Veicolo selezioneVeicolo (int cod);
    List<Veicolo>  elencoVeicoli();
    void eliminaVeicolo(int cod);
    void salvaVeicolo(Veicolo v);

}
