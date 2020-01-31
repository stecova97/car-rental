package main.java.entities;


import javax.persistence.*;


@Entity
@Table(name="casa_automobilistica")
public class Casa_automobilistica {

    @Id
    @Column(name="id", nullable = false)
    private int id;

    @Column(name = "nome" ,nullable =false)
    private String nome;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
