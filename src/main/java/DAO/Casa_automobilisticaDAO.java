package main.java.DAO;

import main.java.entities.Casa_automobilistica;

import java.util.List;

public interface Casa_automobilisticaDAO {
    Casa_automobilistica selezioneCasaAutomobilistica(int id);
    List<Casa_automobilistica> elencoCaseAutomobilistiche();
}
