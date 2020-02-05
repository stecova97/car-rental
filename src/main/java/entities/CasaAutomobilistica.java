package main.java.entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="casa_automobilistica")
public class CasaAutomobilistica {

    @Id
    @Column(name="id_casaAutomobilistica", nullable = false)
    private int idCasaAutomobilistica;

    @Column(name = "nome" ,nullable =false)
    private String nome;

    @OneToMany
    private List<Veicolo> veicolo;

    public int getIdCasaAutomobilistica() {
        return idCasaAutomobilistica;
    }

    public void setIdCasaAutomobilistica(int idCasaAutomobilistica) {
        this.idCasaAutomobilistica = idCasaAutomobilistica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Veicolo> getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(List<Veicolo> veicolo) {
        this.veicolo = veicolo;
    }
}
