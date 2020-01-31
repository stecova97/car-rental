package main.java.entities;

import javax.persistence.*;
import javax.sound.midi.Sequence;


@Entity
@Table(name = "veicolo")
public class Veicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="targa", nullable = false)
    private String targa;

    @Column(name="tipo", nullable = false)
    private String tipo;

    @Column(name="modello", nullable =false)
    private String modello;

    @Column(name="anno_imatricolazione", nullable =false)
    private int anno_immatricolazione;

    @OneToOne(mappedBy = "casa_automobilistica", cascade=CascadeType.REMOVE)
    private int casa_automobilista;


    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno_immatricolazione() {
        return anno_immatricolazione;
    }

    public void setAnno_immatricolazione(int anno_immatricolazione) {
        this.anno_immatricolazione = anno_immatricolazione;
    }

    public int getCasa_automobilista() {
        return casa_automobilista;
    }

    public void setCasa_automobilista(int casa_automobilista) {
        this.casa_automobilista = casa_automobilista;
    }
}
