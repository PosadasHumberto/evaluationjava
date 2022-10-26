package org.hposadas.bibliotheque.models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteque {

    //attributes d'instance
    private Long id;
    private String nom;

    //constructor
    public Biblioteque() {
    }

    public Biblioteque(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
