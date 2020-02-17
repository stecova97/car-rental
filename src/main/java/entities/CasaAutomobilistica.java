package main.java.entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="casa_automobilistica")
public class CasaAutomobilistica {

    @Id
    @Column(name="id_casaAutomobilistica", nullable = false)
    private Integer idCasaAutomobilistica;

    @Column(name = "nome" ,nullable =false)
    private String nome;

    @OneToMany(mappedBy = "casa_automobilista", cascade = CascadeType.ALL)
    private List<Veicolo> veicolo;

    public CasaAutomobilistica() {
    }

    public Integer getIdCasaAutomobilistica() {
        return idCasaAutomobilistica;
    }

    public void setIdCasaAutomobilistica(Integer idCasaAutomobilistica) {
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
