package main.java.DAO;

import main.java.entities.CasaAutomobilistica;

import java.util.List;

public interface CasaAutomobilisticaDAO {
    CasaAutomobilistica selezioneCasaAutomobilistica(int id);
    List<CasaAutomobilistica> elencoCaseAutomobilistiche();
}
