package com.github.domenicost.demo.db.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private String cognome;

    @Column(length = 128)
    private String username;

    @Column(length = 64)
    private String password;

    private int credito;

    @ManyToOne
    private Role role;

    @ManyToMany
    private List<SubReddit> subReddit;

    // Getter e Setter
    public Long getId() {
        return this.id;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<SubReddit> getSubReddit() {
        return subReddit;
    }

    public void setSubReddit(List<SubReddit> subReddit) {
        this.subReddit = subReddit;
    }

    public void addSubReddit(SubReddit subReddit) {
        if (this.subReddit == null)
            this.subReddit = new ArrayList<>();

        this.subReddit.add(subReddit);
    }

    // Altro
    @Override
    public String toString() {
        return "Utente [\n" +
                "  id=" + id + ",\n" +
                "  name=" + nome + ",\n" +
                "  lastname=" + cognome + ",\n" +
                "  username=" + username + ",\n" +
                "  password=" + password + "\n" +
                "  credito=" + credito + "\n" +
                "]";
    }
}
