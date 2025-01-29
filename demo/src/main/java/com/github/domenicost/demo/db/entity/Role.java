package com.github.domenicost.demo.db.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nome;
    
    @Column(length = 64)
    private String descrizione;

    @OneToMany(mappedBy = "role")
    private List<Utente> users;


    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Utente> getUsers() {
        return users;
    }

    public void setUsers(List<Utente> users) {
        this.users = users;
    }

    @Override
    public String toString() {

        return "Regole [\n" +
                "  id=" + id + ",\n" +
                "  name=" + nome + ",\n" +
                "  descrizione=" + descrizione + ",\n" +
                "  users=" + users + ",\n" +
                "]";
    }
    
}
